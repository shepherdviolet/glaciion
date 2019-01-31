# Glaciion Single-Service Mode

```text
If only one implementation is required, select the single-service mode.
You will notice that the annotation on the interface class is @SingleServiceInterface.
It will load which implementation based on the priority in the definition file.
```

[Back to index](https://github.com/shepherdviolet/glaciion/blob/master/docs/index.md)

<br>

## Service caller site

### 1.Write interface class

```text
package sample;

@SingleServiceInterface
public interface SampleSingleService {

    String method();
    
}
```

### 2.Declare in definition file

* Edit file `META-INF/glaciion/interfaces`
* Add a line:

```text
sample.SampleSingleService
```

### 3.Get the service instances

* Load service
* If there is a problem with the definition file / interface class / implementation class, an exception will be thrown.
* [Preloading](https://github.com/shepherdviolet/glaciion/blob/master/docs/preload.md) will be triggered at the first 
time you load a service. The premise is in the `Spring` environment, or the VM option `-Dglaciion.conf.preload.auto=true` is set

```text
//Use the default classloader
SingleServiceLoader<SampleSingleService> loader = Glaciion.loadSingleService(SampleSingleService.class);

//Use the specified classloader
//SingleServiceLoader<SampleSingleService> loader = Glaciion.loadSingleService(SampleSingleService.class, classloader);
```

* Get service instances
* If the instantiation fails, an exception will be thrown

```text
SampleSingleService instance = loader.get();
```

<br>

## Service Provider site

### 1.Write implementation class

```text
package sample;

public class SampleSingleServiceImpl implements SampleSingleService {

    @Override
    public String method() {
        //TO DO logic
    }
    
}
```

* You can inject properties to implementation instance, See [Property Inject](https://github.com/shepherdviolet/glaciion/blob/master/docs/property-injection.md)
* Implementation classes can listen for their own creation and closing events, 
See [Implementation Lifecycle](https://github.com/shepherdviolet/glaciion/blob/master/docs/implementation-lifecycle.md)

### 2.Declare in definition file

* Edit file `META-INF/glaciion/services/single/sample.SampleSingleService`
* Contents:

```text
sample.SampleSingleServiceImpl
```

* Definition file path: META-INF/glaciion/services/single/`interface-classname`
* Definition file contents (Default priority): `implementation-classname`
* Definition file contents (Custom priority): `implementation-classname` `priority`

<br>

## Selection mechanism

* In single-service mode, only one implementation will be loaded
* You can adjust the priority of the implementation in the definition file
* The higher the priority value, the higher the priority, the highest priority implementation will be loaded. the default will be 0 if not set.
* VM option have the highest priority (glaciion.select)
* `TIPS: When there is more than one implementation with the highest priority, which one is loaded according to the hash 
of the implementation class name`

### How to set priority

* Definition file path: META-INF/glaciion/services/single/`interface-classname`
* Definition file contents: `implementation-classname` `priority`

* For example, the priority of sample.SampleSingleServiceImpl is 1

```text
sample.SampleSingleServiceImpl 1
```

* You can increase the priority of implementation by declaring a higher priority definition repeatedly

### Force select the implementation by VM option

* Add VM option: -Dglaciion.select.`interface-classname`=`implementation-classname`
* For example:

```text
-Dglaciion.select.sample.SampleSingleService=sample.SampleSingleServiceImpl
```