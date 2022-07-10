# CRM_System

Create a Spring Boot WEB application using the Thymeleaf library as a view.

We create a mini application for processing CRM system requests. To implement this task, we use the Spring Data + MySQL or PostgreSQL library. Create the main layout (Layout) of your page using the Thymeleaf Layout Dialect library.

It turns out on the main page we will have a list of all applications. Applications themselves will be added via the application form.
The main page will look like this (All applications):
![image](https://user-images.githubusercontent.com/98006856/176594608-ab3e89f9-b48e-46cb-8068-64f7dc0ebbde.png)


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
![image](https://user-images.githubusercontent.com/98006856/176594680-e33794e5-918e-4eec-ad2c-ea004d5d7d24.png)
Processed requests page. (Processed Applications):
![image](https://user-images.githubusercontent.com/98006856/176594661-eea7d401-5342-4959-b9c2-2c3a8a6491dc.png)

In principle, these are all the main functionalities of this mini-project.


We continue to work on the previous project. You will need to add a separate list of operators to the database. These operators will be some handlers of all applications.

 

Operators.java

- Long id;

- Stringname;

- String name;

- String department; //IT, praja, marketing

 

However, this will have to be done. One application can be processed by several operators. For example, one ticket will have 1 operator, another will have 3, and another will have 4, and so on. Plus, one operator can process several applications. Accordingly, you will need to build a link between the request tables and the operator through many-to-many.

 

The assignment process will look like this:
![image](https://user-images.githubusercontent.com/98006856/178149185-67f67a3c-112b-4573-b077-7dffb3f52652.png)

![image](https://user-images.githubusercontent.com/98006856/178149194-61f3fcd6-e0e3-4169-8c31-b180547e19c8.png)

After clicking on "Process Application" you will have a choice of operators:
After clicking on "Assign", you will assign operators to this application. Moreover, the status of the application itself will become processed. And we will not be able to appoint anyone else to the application.

 

As a result, we can see a list of all assigned operators.![image](https://user-images.githubusercontent.com/98006856/178149223-806c95fe-868a-404d-88c2-2445f5c3a720.png)

They can also be deleted.
