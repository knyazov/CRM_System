# CRM_System

Create a Spring Boot WEB application using the Thymeleaf library as a view.

We create a mini application for processing CRM system requests. To implement this task, we use the Spring Data + MySQL or PostgreSQL library. Create the main layout (Layout) of your page using the Thymeleaf Layout Dialect library.

It turns out on the main page we will have a list of all applications. Applications themselves will be added via the application form.
The main page will look like this (All applications):
![image](https://user-images.githubusercontent.com/98006856/176593991-278727cc-2a90-4aef-936b-0f89859912f4.png)

The essence of the application itself will be as follows:

 

ApplicationRequest.java

- Long id;

- String userName;

- String courseName;

- String commentary;

- String phone;

- boolean handled; //processed or not

 

Use the Lombok library to automatically generate constructors, getters and setters.

You should be able to create tasks, see their list, edit the task and, of course, delete it. Use Bootstrap as your CSS library.
you can add a new application (Add application):

![image](https://user-images.githubusercontent.com/98006856/176593485-bfcda3ac-fcc3-45c5-9cf1-ff0f3cdcff15.png)

Further, you can view in detail all applications separately. And when viewing, you can do 2 things:

1. Change status, from new to processed. (change handled field from false to true)

2. Delete the application.

The detailed view will look like this:
![image](https://user-images.githubusercontent.com/98006856/176594156-299545cc-eea3-4e0d-a843-b0dc74c303fe.png)

By clicking on "Delete Application" we permanently delete the application irrevocably.

When you click on "Process Request", we change the handled field from false to true. It turns out that when we add a new application from scratch, the handled field will always be false by default. Moreover, the design of the detailed view of the application will change after we process the application:
![image](https://user-images.githubusercontent.com/98006856/176594233-fa7bebca-c7b2-4dcc-b766-98f285a44ff8.png)
It turns out that after processing we can only delete them.

 

If we pay attention to the header, we can see a separate filtered list of all processed and unprocessed requests.

Page of pending applications. (New applications):
![image](https://user-images.githubusercontent.com/98006856/176594304-76435cb1-6bd8-496c-a014-10ea11286a78.png)
Processed requests page. (Processed Applications):
![image](https://user-images.githubusercontent.com/98006856/176594345-6e34713b-48c4-4aeb-ac74-28f57f5f0d39.png)

In principle, these are all the main functionalities of this mini-project.

