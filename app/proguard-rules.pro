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
-keepattributes Signature
-printconfiguration ./build/full-r8-config.txt

-keep class * implements android.os.Parcelable

# glide
-keep public class * implements com.bumptech.glide.module.GlideModule
-keep public class * extends com.bumptech.glide.module.AppGlideModule
-keep public enum com.bumptech.glide.load.ImageHeaderParser$** {
  **[] $VALUES;
  public *;
}

#If you're targeting any API level less than Android API 27, also include:
-dontwarn com.bumptech.glide.load.resource.bitmap.VideoDecoder

-keep class vn.teko.android.auth.** { *; }

# To preserve the info Crashlytics needs for readable crash reports
-keepattributes *Annotation*
-keepattributes SourceFile,LineNumberTable
-keep public class * extends java.lang.Exception

-keep class vn.teko.service.** { *; }
-keep class vn.teko.android.payment.** { *; }
# because we're using refection to process annotation for android framework module
-keep class vn.teko.android.framework.** { *; }

# keep Kotlin metadata
-keep class kotlin.Metadata { *; }
-keepattributes RuntimeVisibleAnnotations