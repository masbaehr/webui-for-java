# webui-for-java
Simple Java Skeleton for creating Web-based applications (Only leightweight dependencies)

- Starts a HTTP server instance using Undertow Web Server http://undertow.io/ 
- Processes HTTP requests and serves plain HTML / CSS / JS files packaged into the same jar
- Comes with few dependencies. The plan is to keep them updated and only add useful and well-tested dependencies which do not cause a Jar-Hell
  - Gson
  - Commons IO
  - Commons Collections
  - Undertow Core, Xnio API+Impl, JBoss Logging
- No Maven, just "Run as" -> "Java application"

# Use-cases

- Create simple Java-based Applications with nice-looking HTML UX, especially for single/few user environments
- Especially useful if you have to do some tasks which are too complex to achieve with other leightweight environments, or simply if you know Java better than other languages.