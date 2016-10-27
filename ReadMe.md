# BindingImageView-Handler-Glide #

###[BindingImageView 一个适用于DataBinding的ImageView，解决在使用DataBinding时，Uri无法实时绑定ImageView的问题。](https://github.com/EthanCo/BindingImageView)  

BindingImageView-Handler-Glide基于BindingImageView，使用Glide进行了一条龙的实现，无需再自己添加处理项(Handler)

## 添加依赖 ##

### Step 1. Add the JitPack repository to your build file ###

Add it in your root build.gradle at the end of repositories:  

	allprojects {
		repositories {
		    ...
		    maven { url "https://jitpack.io" }
		}
	}

### Step 2. Add the dependency ###

	dependencies {
	    compile 'com.github.EthanCo:BindingImageView-Handler-Glide:1.0.0'
	}

> 无需再添加BindingImageView和Glide依赖


## 使用 ##

在Application#onCreate()初始化  

	BindingImageFacade.init();  

在XML中使用

	<?xml version="1.0" encoding="utf-8"?>
	<layout xmlns:app="http://schemas.android.com/apk/res-auto">
	
	    <data>
	
			<!--TestBean为DataBinding Bean对象，具体可看Sample-->
	        <variable
	            name="testbean"
	            type="com.ethanco.bindingimageviewsample.TestBean" />
	    </data>
	
	    <RelativeLayout xmlns:android="http://schemas.android.com/apk/res/android"
	        android:layout_width="match_parent"
	        android:layout_height="match_parent">
	
	        <com.ethanco.bindingimageview.BindingImageView
	            android:id="@+id/bindingImageView"
	            android:layout_width="200dp"
	            android:layout_height="200dp"
	            android:layout_centerHorizontal="true"
	            app:bindingSrc="@{testbean.imgUrl}" />
	    </RelativeLayout>
	</layout>


在Activity中  

	binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
	TestBean testBean = new TestBean();
    testBean.imgUrl.set("http://img4.duitang.com/uploads/item/201601/16/20160116115247_cAvau.thumb.224_0.jpeg");
    binding.setTestbean(testBean);

之后，如需修改图片，只需

	testBean.imgUrl.set("imageUrl");

即可  


## 控件 ##

### BindingImageView ###

继承自ImageView的View，一般情况下使用这个即可

### BindingCircleImageView ###

继承自CircleImageView的View，如需使用圆形图，使用这个  

### 自定义Binding ImageView ###

可继承任何自定义的ImageView，需实现IBindingImageView接口，添加  BindingImageFacade.handle(obj, this); 即可

	public class BindingCustomImageView extends CustomImageView implements IBindingImageView {

	    public void setBindingSrc(Object obj) {
	        BindingImageFacade.handle(obj, this);
	    }
	}  


## 使用其他图片加载框架 ##
如若使用其他图片加载框架，请看 **[BindingImageView](https://github.com/EthanCo/BindingImageView)** ，自定义实现Handler

