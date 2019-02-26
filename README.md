# MySDk
用于购物车添加或者减少按钮
## 使用方式
### step1
```
allprojects {
		repositories {
			...
			maven { url 'https://www.jitpack.io' }
		}
	}
  ```
  
  ```
  dependencies {
	        implementation 'com.github.lqfGaara:MySDk:v1.2'
	}
  ```
  ![](https://github.com/lqfGaara/MySDk/blob/master/useImag.png)
  ### step2
   ```
  <lqf.com.newbutton.AmountView
        android:id="@+id/amountView"
        android:layout_centerInParent="true"
        android:layout_width="wrap_content"
        app:etTextColor="@color/colorPrimary"
        app:btnTextSize="20sp"
        app:btnWidth="40dp"
        app:tvWidth="60dp"
        android:layout_height="50dp"/>
   ```
  * btnTextSize 按钮的大小
  * etTextColor 中间文字的颜色
  * btnWidth 每一个按钮的宽度
  * tvWidth  中间文字的宽度
 ## 演示效果图 
  >![](https://github.com/lqfGaara/MySDk/blob/master/example.gif)