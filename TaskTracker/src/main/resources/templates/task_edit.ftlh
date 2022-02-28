<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>task</title>
</head>
<body>
<h1>Task information</h1>
<h3>Name - ${task.name}</h3>
<h3>Description - ${task.description}</h3>
<h3>Status - ${task.status}</h3>
<h3>Priority - ${task.priority}</h3>
<br>
<h2>Edit task information</h2>
<form method="post" action="/projects/${project.id}/task/${task.id}/update">
    <label>
        Name: <input name="name" value="${task.name}">
    </label>
    <label>
        Status:
        <select name="status" value="${task.status}">
            <option>ToDo</option>
            <option>InProgress</option>
            <option>Done</option>
        </select>
    </label>
    <label>
        Description: <input name="description" value="${task.description}">
    </label>
    <label>
        Priority: <input name="priority" value="${task.priority}">
    </label>
    <input name="projectId" type="hidden" value="${project.id}">
    <input type="submit" value="Save changes">
</form>
</body>
</html>