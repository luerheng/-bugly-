# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile

#腾讯bugly 为了避免混淆SDK，在Proguard混淆文件中增加以下配置：
-dontwarn com.tencent.bugly.**
-keep public class com.tencent.bugly.**{*;}
#如果你使用了support-v4包，你还需要配置以下混淆规则：
-keep class android.support.**{*;}