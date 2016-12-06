# Animated-Icons [![Release](https://jitpack.io/v/tarek360/Animated-Icons.svg)](https://jitpack.io/#tarek360/Animated-Icons)

![](https://github.com/tarek360/Animated-Icons/raw/master/images/animated_icons.gif)

And more animated icons is coming..

### [Download apk sample](https://github.com/tarek360/Animated-Icons/raw/master/sample.apk)

### Usage

```xml
  <tarek360.animated.icons.AnimatedIconView
     android:id="@+id/animatedIconView"
     android:layout_width="48dp"
     android:layout_height="48dp"/>
```

```java
   animatedIconView.setAnimatedIcon(IconFactory.iconSettings());
```

```java
   animatedIconView.startAnimation();
```




### Installation

Add this to your module `build.gradle` file:
```gradle
dependencies {
  ...
   compile "com.github.tarek360:Animated-Icons:1.2.0"
}
```

Add this to your root `build.gradle` file (**not** your module `build.gradle` file) :
```gradle
allprojects {
  repositories {
    ...
    maven { url "https://jitpack.io" }
  }
}
```

## Vote Up on:
[![](https://github.com/tarek360/Animated-Icons/raw/master/images/material_up.png)](https://material.uplabs.com/posts/animated-icons-library)

## License

>Copyright 2016 Tarek360

>Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

>   http://www.apache.org/licenses/LICENSE-2.0

>Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
