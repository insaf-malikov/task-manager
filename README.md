# Task tracker web application
### Insaf Malikov

## Project was completed 
on Java Spring Boot(JPA, Web, Freemarker)
Datasource may be configured in "application.properties"

### Project architecture
+ Models
Task and Project entities were created. OnetoMany, ManytoOne relation was set 
between them.
+ Controller intercepts requests, sends and gets data.
Controller connects with repositories via service layer. Business logic is covered by "service".
Repositories extend JPA repositories( built-in:find, save, delete). Other methods added by hibernate
sql query generation.
+ Forms are used for handling post requests.
+ Templates are written in FTL. 


## Web application consists of three html pages
+ [host]:[port]/projects 
Allows to view and add projects, delete projects without tasks.
+ "Open" link button directs to the chosen project page [host]:[port]/projects/(project.id)
There is opportunity to edit project information. 
Tasks of the project listed on the same page. It is also possible to add and delete tasks of the project.
+ "Edit" button proceed to the task information editing page: [host]:[port]/projects/(project-id)/task/(task-id)
