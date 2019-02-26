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
  ![](https://github.com/lqfGaara/MySDk/blob/master/useImag.jpg)
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
   名称  | 作用
    --   |:--:
   btnTextSize | 按钮的大小
   etTextColor  |中间文字的颜色
   btnWidth  |每一个按钮的宽度
   tvWidth  | 中间文字的宽度
 ## 演示效果图 
  >![](https://github.com/lqfGaara/MySDk/blob/master/example.gif)

 ```
<lqf.com.newbutton.PullDownSelectionButton
        android:layout_marginTop="20dp"
        android:layout_below="@id/amountView"
        android:id="@+id/pull_bt"
        android:layout_centerInParent="true"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:background="@drawable/bt_background"
        app:buttonHeight="50dp"
        app:buttonWidth="80dp"
	app:text="123"
        app:buttonTextColor="#666666"
        app:textSize="20sp" />
 ```
姓名|技能|排行
--|:--:|--:
刘备|哭|大哥
关羽|打|二哥
张飞|骂|三弟

 名称  | 作用
    --|:--
   buttonHeight | 按钮的高度
   buttonWidth  |按钮的宽度
   buttonTextColor  |文字颜色
   textSize  | 中间文字的大小
   text | 需要默认显示的文字
   background | 按钮的背景
