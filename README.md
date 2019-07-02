# AlertDialog
[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)

Custom Alert Dialog with styles

<img src="https://github.com/yeyintkoko1788/AlertDialog/blob/master/alert.gif" style="max-width:100%;">

AlertDialog with custom style

<h2> Prerequisites </h2>

Add this to your module's <code>build.gradle</code> file
<pre>
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
</pre>

<h2>Dependency</h2>

Add this to your module's <code>build.gradle</code> file

<pre>
dependencies {
	        implementation 'com.github.yeyintkoko1788:AlertDialog:v1.0.0'
	}
</pre>

<h2>How To Use</h2>

In your activity or fragment setup <code>CustomAlertDialog</code>
This method always returns a AlertDialog object, so you can customize the Alert much more.

<pre>
CustomAlertDialog dialog = new CustomAlertDialog(this, style);
</pre>

For <code>style</code> parameter you choose:

<pre>
CustomAlertDialog.DialogStyle.DEFAULT
CustomAlertDialog.DialogStyle.NO_ACTION_BAR
CustomAlertDialog.DialogStyle.CURVE
CustomAlertDialog.DialogStyle.FILL_STYLE
</pre>
More Style will come soon
<code>DEFAULT</code>
<img src="https://github.com/yeyintkoko1788/AlertDialog/blob/master/65543114_463743791070031_1596529087264849920_n.jpg" style="max-width:100%;">

<code>NO_ACTION_BAR</code>
<img src="https://github.com/yeyintkoko1788/AlertDialog/blob/master/65513878_2527686170629817_7259463425753874432_n.jpg" style="max-width:100%;">

<code>CURVE</code>
<img src="https://github.com/yeyintkoko1788/AlertDialog/blob/master/65569826_313032479649690_683031415041818624_n.jpg" style="max-width:100%;">

<code>FILL_STYLE</code>
<img src="https://github.com/yeyintkoko1788/AlertDialog/blob/master/65164560_2253940951537409_8369428656035987456_n.jpg" style="max-width:100%;">

<li>Use this methods to set <b>Alert Title (except for FILL_STYLE alert)</b> and <b>Alert Message</b></li>

<pre>
dialog.setAlertTitle("Alert Title");
dialog.setAlertMessage("Alert message...");
</pre>

<li>For <b>Positive</b> and <b>Negative</b> button use following method with <code>onClickListener</code></li>

<pre>
dialog.setPositiveButton("Ok", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Positive Button Clicked",Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });
        dialog.setNegativeButton("Cancel", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Negative Button Clicked",Toast.LENGTH_SHORT).show();
                dialog.cancel();
            }
        });
</pre>
<li>You can also set Alert Dialog type for all style, Such as</li>
<pre>
dialog.setDialogType(CustomAlertDialog.DialogType.ERROR);
</pre>
Currently available type are:
<pre>
CustomAlertDialog.DialogType.DEFAULT
CustomAlertDialog.DialogType.ERROR
CustomAlertDialog.DialogType.SUCCESS
CustomAlertDialog.DialogType.INFO
CustomAlertDialog.DialogType.WARNING
</pre>

<li>For <code>NO_ACTION_BAR</code> and <code>FILL_STYLE</code> alert style you can set your own image <code>drawable</code> along with image tint color if you don't want image tint you can simply set this attribute to 0

<pre>
dialog.setDialogImage(getDrawable(R.drawable.alert),0); // no tint
dialog.setDialogImage(getDrawable(R.drawable.alert),getResources().getColor(R.color.colorWhite)); //with tint
</pre>

<li> You can also define size of image you set by using this method</li>
<pre>
dialog.setImageSize(150,150);
</pre>

<li> Finally you can <code>create</code> and <code>show</code> your alert <b> Don't forget to add this two</b>

<pre>
dialog.create();
dialog.show();
</pre>

This is my first library, so hope you guys enjoy its and feel free to give any suggesting. 
