# Glaciion Multiple-Service Mode

```text
If multiple implementations are required, select the multiple-service mode.
You will notice that the annotation on the interface class is @MultipleServiceInterface.
It will load which implementations based on the enable(+) and disable(-) sign in the definition file.
The service loader can get an instance by name or a list of all instances (sorted by priority).
```

[Back to index](https://github.com/shepherdviolet/glaciion/blob/master/docs/index.md)

<br>

## Service caller site

### 1.Write interface class

```text
package sample;

@MultipleServiceInterface
public interface SampleMultipleService {

    String method();
    
}
```

### 2.Declare in definition file

* Edit file `META-INF/glaciion/interfaces`
* Add a line:

```text
sample.SampleMultipleService
```

### 3.Get the service instances

* Load service
* If there is a problem with the definition file / interface class / implementation class, an exception will be thrown.
* [Preloading](https://github.com/shepherdviolet/glaciion/blob/master/docs/preload.md) will be triggered at the first 
time you load a service. The premise is in the `Spring` environment, or the VM option `-Dglaciion.conf.preload.auto=true` is set

```text
//Use the default classloader
MultipleServiceLoader<SampleMultipleService> loader = Glaciion.loadMultipleService(SampleMultipleService.class);

//Use the specified classloader
//MultipleServiceLoader<SampleMultipleService> loader = Glaciion.loadMultipleService(SampleMultipleService.class, classloader);
```

* Get service instances
* If the instantiation fails, an exception will be thrown

```text
//Get by name
SampleMultipleService instance = loader.get("name");

//Get all (Sort by implementation priority, the higher the priority value, the higher the priority, the 0th has the highest priority)
List<SampleMultipleService> instances = loader.getAll();
```

<br>

## Service Provider site

### 1.Write implementation class

```text
package sample;

//Name, Optional, Cannot get by name without setting it
@ImplementationName("name")
//Priority, Optional, 0 by default, The higher the priority value, the higher the priority, the 0th has the highest priority
@ImplementationPriority(1)
public class SampleMultipleServiceImpl1 implements SampleMultipleService {

    @Override
    public String method() {
        //TO DO logic
    }
    
}
```

* You can inject properties to implementation instance, See [Property Inject](https://github.com/shepherdviolet/glaciion/blob/master/docs/property-injection.md)
* Implementation classes can listen for their own creation and closing events, 
See [Implementation Lifecycle](https://github.com/shepherdviolet/glaciion/blob/master/docs/implementation-lifecycle.md)
* `TIPS: When the implementation name is repeated, only one can be obtained by name, and the others can only be obtained by getAll.`
* `TIPS: When the implementation priorities are the same, sort according to the hash of the implementation class name`

### 2.Declare in definition file

* Edit file `META-INF/glaciion/services/multiple/sample.SampleMultipleService`
* Contents:

```text
+sample.SampleMultipleServiceImpl1
+sample.SampleMultipleServiceImpl2
+sample.SampleMultipleServiceImpl3
```

* Definition file path: META-INF/glaciion/services/multiple/`interface-classname`
* Definition file contents: +`implementation-classname`

<br>

## Plug and unplug mechanism

* In multiple-service mode, we can load multiple implementations
* In the definition file, there are two commands, enabled(+) and disabled(-)
* Enable(+) and disable(-) commands have different levels, +/- is level 1, ++/-- is level 2, +++/--- is level 3 ... (No length limit)
* If the levels are the same, the disable's priority is higher than the enable's
* VM option have the highest priority (glaciion.delete)

```text
The logic to determine if an implementation is enabled is to see the highest level of commands, disable if there is a `-`, 
enable if all are '+'. In actual use, if you want to enable an implementation, you need to add a higher level enable 
command. If you want to disable one, just add a disable command with the same level as the highest level.
```

### Example

* Definition file path: META-INF/glaciion/services/multiple/`interface-classname`

#### In the following examples, the service is finally enabled

* Highest level is 1, and there is only one '+', service enabled

```text
+sample.SampleMultipleServiceImpl1
```

* Highest level is 2, and there is only one '++', service enabled

```text
+sample.SampleMultipleServiceImpl1
-sample.SampleMultipleServiceImpl1
++sample.SampleMultipleServiceImpl1
```

#### In the following examples, the service is finally disabled

* Highest level is 1, and there is a '-', service disabled

```text
+sample.SampleMultipleServiceImpl1
-sample.SampleMultipleServiceImpl1
```

* Highest level is 2, and there is a '--', service disabled

```text
+sample.SampleMultipleServiceImpl1
-sample.SampleMultipleServiceImpl1
++sample.SampleMultipleServiceImpl1
--sample.SampleMultipleServiceImpl1
```

### Force delete implementation by VM option

* Add VM option: -Dglaciion.remove.`interface-classname`=`implementation-classname`,`implementation-classname`
* For example:

```text
-Dglaciion.remove.sample.SampleMultipleService=sample.SampleMultipleServiceImpl1,sample.SampleMultipleServiceImpl2
```