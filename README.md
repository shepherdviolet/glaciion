# Glaciion 2.0.5 (No longer maintained)

[![Language grade: Java](https://img.shields.io/lgtm/grade/java/g/shepherdviolet/glaciion.svg?logo=lgtm&logoWidth=18)](https://lgtm.com/projects/g/shepherdviolet/glaciion/context:java)

* `No longer maintained, superseded by https://github.com/shepherdviolet/glacimon`
* `不再维护, 请用新项目: https://github.com/shepherdviolet/glacimon`
* A library of Java Service Provider Interface
* [Github Home](https://github.com/shepherdviolet/glaciion)
* [Search in Maven Central](https://search.maven.org/search?q=g:com.github.shepherdviolet)
* [PGP Key](https://keyserver.ubuntu.com/pks/lookup?search=0x90998B78AABD6E96&fingerprint=on&op=index)

## What's SPI and Glaciion?

```text
Service provider interface is a feature for discovering and loading implementations matching the given interface. 
Glaciion is an implementation of service provider interface feature. It can make your library expandable. 
```

## Documents

* [English Documents](https://github.com/shepherdviolet/glaciion/blob/master/docs/index.md)
* [中文文档](https://github.com/shepherdviolet/glaciion/blob/master/docs/index-cn.md)

## Import dependencies from maven repository

* [Search `glaciion-core` in Maven Central](https://search.maven.org/search?q=g:com.github.shepherdviolet%20a:glaciion-core)

```gradle
repositories {
    //glaciion in mavenCentral
    mavenCentral()
}
dependencies {
    compile 'com.github.shepherdviolet:glaciion-core:?'
}
```

```maven
    <dependency>    
        <groupId>com.github.shepherdviolet</groupId>
        <artifactId>glaciion-core</artifactId>
        <version>?</version> 
    </dependency>
```
