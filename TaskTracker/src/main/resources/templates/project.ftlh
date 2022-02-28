<!doctype html>
<html lang="en">
<#setting date_format="yyyy-MM-dd">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>${project.name}</title>
</head>
<body>
<h1>Project Information</h1>
<h3>Name - ${project.name}</h3>
<h3>Status - ${project.status}</h3>
<h3>Start date - ${project.startDate}</h3>
<h3>Complete date - ${project.completeDate}</h3>
<h3>Priority - ${project.priority}</h3>
<h3>Edit project information</h3>
<form method="post" action="/projects/${project.id}/update">
<label>
    Name: <input name="name" value="${project.name}">
</label>
<label>
    Status:
        <select name="status" value="${project.status}">
            <option>NotStarted</option>
            <option>Active</option>
            <option>Completed</option>
        </select>

</label>
    <label>
        Start date: <input name="startDate" value="${project.startDate}">
    </label>
    <label>
        Complete date: <input name="completeDate" value="${project.completeDate}">
    </label>

<label>
    Priority: <input name="priority" value="${project.priority}">
</label>
<input type="submit" value="Save changes">
</form>

<h1>Project tasks</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Description</th>
        <th>Status</th>
        <th>Priority</th>
    </tr>
    <#list tasks as task>
        <tr>
            <td>${task.id}</td>
            <td>${task.name}</td>
            <td>${task.description}</td>
            <td>${task.status}</td>
            <td>${task.priority}</td>
            <td>
                <form method="post" action="/projects/${project.id}/task/${task.id}/delete">
                    <input type="submit" value="DELETE">
                </form>
            </td>
            <td>
                <a href="/projects/${project.id}/task/${task.id}">edit</a>
            </td>
        </tr>
    </#list>
</table>
<h2>Add task to the project</h2>
<form method="post" action="/task/add">
    <label>Name
        <input name="name" placeholder="Name">
    </label>
    <label>Description
        <input name="description" placeholder="set description">
    </label>
    <label>Status
        <select name="status">
            <option>ToDo</option>
            <option>InProgress</option>
            <option>Done</option>
        </select>
    </label>
    <label>Priority
        <input name="priority" placeholder="set priority 1 to 5">
    </label>
    <input name="projectId" type="hidden" value="${project.id}">
    <input type="submit" value="Add">
</form>
</body>
</html>