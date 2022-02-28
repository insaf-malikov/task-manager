<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Projects List</title>
</head>
<body>
<h1>Projects</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Status</th>
        <th>Start date</th>
        <th>Complete date</th>
        <th>Priority</th>
    </tr>
    <#list projects as project>
        <tr>
            <td>${project.id}</td>
            <td>${project.name}</td>
            <td>${project.status}</td>
            <td>${project.startDate}</td>
            <td>${project.completeDate}</td>
            <td>${project.priority}</td>
            <td>
                <form method="post" action="/projects/${project.id}/delete">
                    <input type="submit" value="DELETE">
                </form>
            </td>
            <td>
                <a href="projects/${project.id}">Open</a>
            </td>
        </tr>
    </#list>
</table>
<h1>Add New Project</h1>
<form method="post" action="/projects/add">
    <label>Name
        <input name="name" placeholder="Name">
    </label>
    <label>Status
        <select name="status">
            <option>NotStarted</option>
            <option>Active</option>
            <option>Completed</option>
        </select>
    </label>
    <label>Priority
        <input name="priority" placeholder="set priority 1 to 5">
    </label>
    <label> Start Date
        <input name="startDate" placeholder="YYYY-MM-dd">
    </label>
    <label> Complete Date
        <input name="completeDate" placeholder="YYYY-MM-dd">
    </label>
    <input type="submit" value="Add">
</form>
</body>
</html>