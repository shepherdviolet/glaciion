# Glaciion 2.0.1

* A library of Java Service Provider Interface
* Git: https://github.com/shepherdviolet/glaciion

## What's SPI and Glaciion?

```text
Service provider interface is a feature for discovering and loading implementations matching the given interface. 
Glaciion is an implementation of service provider interface feature. It can make your library expandable. 
```

## Documents

* [English Documents](https://github.com/shepherdviolet/glaciion/blob/master/docs/index.md)
* [中文文档](https://github.com/shepherdviolet/glaciion/blob/master/docs/index-cn.md)

## Import dependencies from maven repository

```gradle
repositories {
    //glaciion in mavenCentral
    mavenCentral()
}
dependencies {
    compile 'com.github.shepherdviolet.glaciion2:glaciion-core:version'
}
```

```maven
    <dependency>    
        <groupId>com.github.shepherdviolet.glaciion2</groupId>
        <artifactId>glaciion-core</artifactId>
        <version>version</version> 
    </dependency>
```
