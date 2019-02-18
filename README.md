# ImageGallery
Image Gallery Application

# Linking Tomcat server to fetch images from folder structure
Adding a link to the folder structure holding the images add the following line to -
apache-tomcat-9.0.13\conf > server.xml
=> Example: <pre><code><Context docBase=[file path] path=/static /></code></pre>

- Now start the relative path in the application with /static (this can be any name based on the configured value)

# Deployment Steps
1. In the root directory run => <code> mvn package </code> to create a .war file
2. Get the new .war file created from <code>/target</code> folder.
3. Copy this .war file into <code>/webapp</code> folder in tomcat.

# Running the application
- In the browser type <code>localhost:8080/profile/all</code>
