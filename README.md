# Glaciion 2.0.4

* A library of Java Service Provider Interface
* [Github Home](https://github.com/shepherdviolet/glaciion)
* [Search in Maven Central](https://search.maven.org/search?q=g:com.github.shepherdviolet)
* [PGP Key](http://pool.sks-keyservers.net/pks/lookup?op=vindex&fingerprint=on&search=0x90998B78AABD6E96)

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
