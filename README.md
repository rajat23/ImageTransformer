# ImageTransformer  [![Build Status](https://travis-ci.org/akshaysyaduvanshi/ImageTransformer.svg?branch=master)](https://travis-ci.org/akshaysyaduvanshi/ImageTransformer)

Image Transformations
=============

You can resize or crop the images in various ways. Doing so is done by simply directing your users to an address URL that includes the transformation instructions. You can change the required transformations at any time and all transformed images will be created on-demand (lazily) and delivered to your users. 
You can also give effects to images such as sepia, negate etc. You can also compress image using JPEG compression.

You can use images from two sources. Either uploaded image can used or you can also specify image url. Parameter which is used to provide image source is path. Path parameter can be set by following ways.<br><br>
Setting path for allready uploaded image path=sample.jpg<br><br>
Setting path as url of image path =http://indianapublicmedia.org/arts/files/2012/04/sample-gates-9-940x626.jpg<br><br>
Following examples show how to access uploaded image and remote images by providing url<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg<br><br>

http://imagetransformer.herokuapp.com/image/transform?path=http://indianapublicmedia.org/arts/files/2012/04/sample-gates-9-940x626.jpg
	
Image Scaling	
=============
You can resize image by providing image width or height. Other dimension will be calculated form provided dimension and aspect ratio of image.<br><br> For example following url aks for image width 400 in this case height is automatically calculated. In second example only height is provided.<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&width=400,<br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&height=400<br><br>
You can also resize image by providing image width or height in fraction. Other dimension will be calculated form provided dimension and aspect ratio of image.<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&width=0.6<br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&height=0.3
							
							
Scaling Modes
=============
If you provide both the height and width of required image then provided dimension may not keep aspect ratio. So to keep aspect ratio six scaling modes are provided. For selecting a mode you need to use mode parameter. The default mode is pad mode and default pad color is white. Here are the supported modes and some examples:
							
Fit
=============
Change image size to fit in the given width & height while retaining original proportions. All original image parts are visible. Both width and height dimensions of the transformed image must not exceed the specified width & height. However, they may be smaller than the specified values in order to keep the original proportion.For example, fitting the sample image 300x300:<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&height=300&width=300&mode=fit<br><br>
The generated image is actually 300x200 in order to keep the original proportions 1.5. Fitting the image to 300x300 will actually generate a 300x200 image (retaining the 1.5 aspect ratio)
							
Fill
=============							
Create an image with the exact given width and height while retaining original proportions. Use only part of the image that fills the given dimensions. Only part of the original image might be visible if the required proportions are different than the original ones.<br><br>For example, filling a 300x300 rectangle based on the sample image:<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&height=300&width=300&mode=fill<br><br>
The generated image is exactly 300x300 while not all flowers are visible.<br><br>
When using the 'fill' mode, you can specify which part of the original image to use for filling the required dimensions in case the proportions do not match. You can do so by using the orientation parameter, which defined which part of the image to take.<br><br>
The supported gravity values are: top, bottom, left, right, top-left,top-right, bottom-left, bottom-right.
In the example above, no orientation was specified, so the default 'center' orientation was used. In the following example we fill a 300x100 rectangle while using top corner of the sample image:<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&height=100&width=300&mode=fill&orientation=top
							
							
Limit
=============
The limit mode is used for creating an image that does not exceed the given width or height. If the original image is smaller than the given limits, the generated image is identical to the original one. If the original is bigger than the given limits, it will be resized while retaining original proportions (similar to the 'fit' mode in this case).For example, limiting the sample image to 300x300 will generate an image identical to the 'fit' mode:<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&height=300&width=300&mode=limit<br>
							
Specifying width & height bigger than the original will simply return the original image:<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&height=3000&width=3000&mode=limit
						
							
Pad
=============
Resize the image to fill the given width & height while retaining original proportions.If proportions of the originals image do not match the required ones, pad the image for reaching exactly the required size. You can specify the 'orientation' to selecting which part of the original image to use for filling the rectangle.<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&height=300&width=300&mode=pad&orientation=bottom<br><br>
You can also provide pad color. The parameter used for providing color is 'color'. Color can pe give in 3 ways 
Color name ex. blue, green, violet
Hex values color=0xffddee 
RGB values ex color=r_122,g_233,b_145<br><br>
For example: Resizing image to 300*300 with pad color=yellow<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&height=300&width=300&mode=pad&color=yellow
							
Crop
=============
The 'crop' mode is used to extract only part of a given width & height out of the original image. The original proportions are retained and so is the size of the graphics. You can specify the orientation to use for selecting which image part to take.<br>For example, generating a 300x300 image based on the 300x300 top left pixels of the original image:<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&height=300&width=300&mode=crop&orientation=top-left<br><br>
Another way to crop image is by providing value of 'x' and 'y' parameter and required height and width. You can specify either height or width or both.<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&height=300&width=300&mode=crop&x=20&y=30
							
Rounded corner cropping
=============
Transforming an image to a rounded version is done using the 'radius' parameter. It accepts the number of pixels the radius of all four corners should be.<br>The following example transforms an uploaded JPG to a 300x200  with rounded corners of 30 pixels.<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&height=300&width=200&mode=fit&radius=30
							
Effects
=============
Various effect can be applied to image. To select effect 'effect' parameter is used. Provided effects are sepia, grayscale, blackwhite, negate, oilpaint, pixelate, brightness.The following example gives sample.jpg image a sepia effect <br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&effect=sepia

Rotating Image
=============
Image can be rotated using angle parameter. You can specify angle in degrees. Positive value of angle will rotate image clockwise and viceversa.Also you can specify modes.Two modes are provided vflip and hflip. Modes should also be assigned to angle parameter.<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&angle=10
<br><br>
http://imagetransformer.herokuapp.com/image/transform?path=sample.jpg&angle=hflip

							
 
