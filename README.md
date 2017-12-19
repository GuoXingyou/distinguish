#实现的识别身份证号码

应公司需求，参考网上资料案例搞的一个简单的识别身份证号码的程序，这里用了google的tesseract引擎
（需要安装tesseract），然后用相应提供的tess4j包完成，其实就是相当于用java代码执行tesseract引
擎的命令，tesseract必须用3.0以上版本才能识别中文，引擎中的tessdata/configs中的digits文件内容修
改为：
````
tessedit_char_whitelist 0123456789X.
````
以加强识别身份证号码（国内身份证为阿拉伯数字+X组成）

#另一个思路使用openCV来识别，不过时间有限暂未研究...
