# ImageGallery
Image Gallery Application

# Linking Tomcat server to fetch images from folder structure
Adding a link to the folder structure holding the images add the following line to -
apache-tomcat-9.0.13\conf > server.xml
=> Example: <Context docBase="E:\test\documents\gallary\main" path="/static" />
