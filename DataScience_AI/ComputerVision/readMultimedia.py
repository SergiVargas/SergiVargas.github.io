#This program shows how to read and manipulate photos and videos

import cv2 as cv

#Save the photo in a variable
image = cv.imread('material/arbol1.jpg')

#Show the image, Tree is the label of the image
cv.imshow('Tree', image)

#This method allows you to keep the image until you press a key
cv.waitKey(0)


"""  #remove comments to play video

#Read and save the video frame by frame
capture= cv.VideoCapture('material/cartepillar.mp4')


#Loop to save video and play it
while True:
    isTrue, frame = capture.read()
    cv.imshow('Video', frame)
    
    if cv.waitKey(20) & 0xFF == ord('d'):
        break
    
capture.release()
cv.destroyAllWindows()
cv.waitKey(0)   """



#Let's manipulate this image that is bigger
image2 = cv.imread('material/arbol2.jpg')

#Before manipulate
cv.imshow('Tree2Before',image2)
cv.waitKey(0)


#Creating a function to rescale, default value = 0.50
def rescale(frame, scale = 0.50):
    """
    This function is for images, videos and live videos
    """
    width = int(frame.shape[1] * scale)
    height = int(frame.shape[0] * scale)
    dimensions = (width, height)
    
    return cv.resize(frame, dimensions, interpolation = cv.INTER_AREA)
    


imageRescale = rescale(image2)


#After manipulate
cv.imshow('Tree2After',imageRescale)
cv.waitKey(0)
