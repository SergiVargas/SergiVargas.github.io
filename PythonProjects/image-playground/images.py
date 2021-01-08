from PIL import Image, ImageFilter

"""
img = Image.open("./pokedex/pikachu.jpg")
filtered_img = img.filter(ImageFilter.BLUR)
filtered_img.save("blur.png", 'png')
filtered_img.show()"""

imagen = Image.open("grey.png").resize((70,70)).show()
