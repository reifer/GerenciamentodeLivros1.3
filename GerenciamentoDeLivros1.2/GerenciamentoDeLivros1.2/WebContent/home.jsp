<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link href="./css/style.css" rel="stylesheet" />
	<link rel="stylesheet" href="./css/bootstrap.min.css" />
	<script src="./js/bootstrap.min.js"></script>
	<script src="./js/jquery-3.3.1.min.js"></script>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Home</title>
</head>

<body class="bodyHome backgroundImage">
    <div class="formHome">
        <div class="titleHome">
            <h1>Gerenciamento de Livros</h1>
        </div>
        <form action="./" method="post">
        <div class="container containerHome">
            <div class="buttonHomePosition">
                <button type="submit" class="btn btn-primary buttonHome">Cadastro de Livros</button>
            </div>
            <div class="buttonHomePosition">
                <button type="submit" class="btn btn-primary buttonHome">Cadastrar Usuario</button>
            </div>
            <div class="buttonHomePosition">
                <button type="submit" class="btn btn-primary buttonHome">Emprestimo</button>
            </div>
            <div class="buttonHomePosition">
                <button type="submit" class="btn btn-primary buttonHome">Devolução</button>
            </div>
        </div>
        </form>
    </div>
</body>

</html>