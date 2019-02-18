# ImageGallery
Image Gallery Application

# Linking Tomcat server to fetch images from folder structure
Adding a link to the folder structure holding the images add the following line to -
apache-tomcat-9.0.13\conf > server.xml
=> Example: <pre><code><Context docBase=[file path] path=/static /></code></pre>

- Now start the relative path in the application with /static (this can be any name based on the configured value)
