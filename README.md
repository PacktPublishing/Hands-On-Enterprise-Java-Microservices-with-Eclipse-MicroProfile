# Hands-On Enterprise Java Microservices with Eclipse MicroProfile 

<a href="https://www.packtpub.com/web-development/hands-on-enterprise-java-microservices-with-eclipse-microprofile?utm_source=github&utm_medium=repository&utm_campaign=9781838643102"><img src="https://www.packtpub.com/media/catalog/product/cache/e4d64343b1bc593f1c5348fe05efa4a6/9/7/9781838643102-original.jpeg" alt="Hands-On Enterprise Java Microservices with Eclipse MicroProfile " height="256px" align="right"></a>

This is the code repository for [Hands-On Enterprise Java Microservices with Eclipse MicroProfile](https://www.packtpub.com/web-development/hands-on-enterprise-java-microservices-with-eclipse-microprofile?utm_source=github&utm_medium=repository&utm_campaign=9781838643102), published by Packt.

**Build and optimize your microservice architecture with Java**

## What is this book about?
Eclipse MicroProfile has gained momentum in the industry as a multi-vendor, interoperable, community-driven specification. It is a major disruptor that allows organizations with large investments in enterprise Java to move to microservices without spending a lot on retraining their workforce.


This book covers the following exciting features:
* Understand why microservices are important in the digital economy 
* Analyze how MicroProfile addresses the need for enterprise Java microservices 
* Test and secure your applications with Eclipse MicroProfile 
* Get to grips with various MicroProfile capabilities such as OpenAPI and Typesafe REST Client 
* Explore reactive programming with MicroProfile Stream and Messaging candidate APIs 
* Discover and implement coding best practices using MicroProfile

If you feel this book is for you, get your [copy](https://www.amazon.com/dp/1838643109) today!

<a href="https://www.packtpub.com/?utm_source=github&utm_medium=banner&utm_campaign=GitHubBanner"><img src="https://raw.githubusercontent.com/PacktPublishing/GitHub/master/GitHub.png" 
alt="https://www.packtpub.com/" border="5" /></a>

## Instructions and Navigations
All of the code is organized into folders. For example, Chapter02-govandcontribs.

The code will look like the following:
```
package org.eclipse.microprofile.health;

@FunctionalInterface
public interface HealthCheck {
  HealthCheckResponse call();
}
```

**Following is what you need for this book:**
If you're a Java developer who wants to create enterprise microservices, this book is for you. Familiarity with Java EE and the concept of microservices will help you get the most out of this book.	

With the following software and hardware list you can run all code files present in the book (Chapter 1-10).
### Software and Hardware List
| Chapter | Software required | OS required |
| -------- | ------------------------------------ | ----------------------------------- |
| 1-10 | Java 8 | Any with JVM support |
| 1-10 | Maven 3.6 | Any with JVM support |
| 1-10 | Docker | Any with JVM support |

We also provide a PDF file that has color images of the screenshots/diagrams used in this book. [Click here to download it](https://static.packt-cdn.com/downloads/9781838643102_ColorImages.pdf).

## Errata
* Page 78 (Information Box): **MicroProfile Metrics is developing the 2.x version of the specification that has some breaking changes to 1.x.** _should be_ **MicroProfile Metrics is developing the 2.0 version of the specification that has some breaking changes to 1.x.**

* Page 176 (Line 9): **The Reactive Manifesto defines the characteristics of reactive systems to including an asynchronous messaging core that is used to build elastic, resilient systems.** _should be_ **The Reactive Manifesto defines the characteristics of reactive systems to include an asynchronous messaging core, which is used to build elastic, resilient systems.**

* Page 178 (Paragraph 5, line 1): **The MP-RM specification defines a number of supported signature types that beans can use to define publish and subscriber behaviors.** _should be_ **The MP-RM specification defines several supported signature types that beans can use to define publisher and subscriber behaviors.**

* Page 179 (Paragraph 6, line 2): **The publisher method types of methods all have an @Outgoing("channel-name") annotation and support signatures as follows:** _should be_ **All  publisher method types have an @Outgoing("channel-name") annotation and support signatures as follows:**

### Related products
* Mastering Microservices with Java - Third Edition  [[Packt]](https://www.packtpub.com/application-development/mastering-microservices-java-third-edition?utm_source=github&utm_medium=repository&utm_campaign=9781789530728) [[Amazon]](https://www.amazon.com/dp/1785285173)

* Microservice Patterns and Best Practices  [[Packt]](https://www.packtpub.com/application-development/microservice-patterns-and-best-practices?utm_source=github&utm_medium=repository&utm_campaign=9781788474030) [[Amazon]](https://www.amazon.com/dp/1788474031)

## Get to Know the Author
**Cesar Saavedra**
has been working in the IT industry since 1990 and holds a master of science degree in computer science and an MBA. He has worked as a developer, consultant, technical seller, and technical marketer throughout his career. He currently does technical product marketing for Red Hat JBoss EAP, Eclipse MicroProfile, OpenJDK, Quarkus, and Jakarta EE. He also manages technical marketing for the runtimes, integration, Business Process Management (BPM), and rules management portfolio, and works closely with engineering and product management on thought leadership. Cesar has authored white papers, e-Books, and blog posts, and is a conference and webinar speaker, giving presentations to customers and partners.

**Heiko W. Rupp**
is an open source enthusiast with more than a decade of experience working at Red Hat in the area of middleware monitoring and management. In this role, he has been project lead of the RHQ and Hawkular monitoring systems and has also contributed to various other projects, including Kiali.

Currently, he is helping to define the next route to be taken by Java microservices with his work on Eclipse MicroProfile. As such, he is the specification lead of the Eclipse MicroProfile Metrics effort and is also contributing to other specifications. Heiko has written the first German book about JBoss AS and one of the first German books on EJB3. He lives with his family in Stuttgart, Germany.

**Jeff Mesnil**
is employed by Red Hat as a senior software engineer and currently works for JBoss, Red Hat's middleware division, on the WildFly and JBoss EAP application servers. He is a member of the core team in charge of developing the internals of the application servers and heads up its messaging subsystem (which provides the JMS API).

Previously, he contributed to the HornetQ messaging broker that was integrated into WildFly and EAP.

He is a proponent of open source development and all the code he writes, either professionally or privately, is available under open source licenses. Nowadays, it is mostly hosted on GitHub.

He has a keen interest in messaging systems and has written several open source libraries related to messaging.

**Pavol Loffay**
is senior software engineer at Red Hat. Pavol is working on observability tools for microservice architectures. He is mostly involved in the tracing domain, where he is an active committer on the Jaeger and OpenTracing projects. He is also a member of the OpenTracing Specification Council (OTSC) and a lead for the MicroProfile-OpenTracing specification. He has authored many blog posts and given presentations at several conferences. In his free time, Pavol likes to climb mountains and ski steep slopes in the Alps.

**Scott Stark**
began his career in chemical engineering, got steered into parallel computers as part of his PhD work, and then made software his career, beginning with a stint in finance on Wall Street. He then got into open source with the fledgling JBoss company, working on the application server and Java EE. He has worked with microkernel efforts, the IoT, standards, Jakarta EE, Eclipse MicroProfile, and Quarkus. He lives in the Pacific Northwest with his wife.

### Suggestions and Feedback
[Click here](https://docs.google.com/forms/d/e/1FAIpQLSdy7dATC6QmEL81FIUuymZ0Wy9vH1jHkvpY57OiMeKGqib_Ow/viewform) if you have any feedback or suggestions.


### Download a free PDF

 <i>If you have already purchased a print or Kindle version of this book, you can get a DRM-free PDF version at no cost.<br>Simply click on the link to claim your free PDF.</i>
<p align="center"> <a href="https://packt.link/free-ebook/9781838643102">https://packt.link/free-ebook/9781838643102 </a> </p>