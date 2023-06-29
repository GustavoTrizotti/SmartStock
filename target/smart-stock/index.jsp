<%@page contentType="text/html; chartset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="br.edu.ifsp.dsw3.model.dao.*,br.edu.ifsp.dsw3.model.domain.*"%>

<!DOCTYPE html>
<html lang="pt-br">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <script src="https://cdn.tailwindcss.com"></script>
  <title>Smartstock | Log-in</title>
</head>
<body class="bg-gradient-to-r from-sky-300 to-purple-600 flex items-center justify-center min-h-screen">
  <div class="container w-1/4 bg-white h-full p-5 border-b-8 rounded-md drop-shadow-lg">
    <h1 class="text-3xl font-bold text-center p-3 m-3 text-indigo-500 uppercase">Register</h1>
    <form method="post" class="p-3 flex flex-col my-auto">
      <label class="text-lg font-semibold">Username</label>
      <input type="text" class="text-lg p-3 bg-gradient-to-r from-sky-100 to-purple-100 outline-none my-3">
      <label class="text-lg font-semibold">E-mail</label>
      <input type="text" class="text-lg p-3 bg-gradient-to-r from-sky-100 to-purple-100 outline-none my-3">
      <label class="text-lg font-semibold">Password</label>
      <input type="text" class="text-lg p-3 bg-gradient-to-r from-sky-100 to-purple-100 outline-none my-3">
      <button type="submit" class="w-full bg-gradient-to-r from-sky-300 to-purple-400 text-white p-3 text-lg uppercase font-bold my-3 hover:opacity-80 transition-all">Send</button>
      <a href="register.jsp" class="text-indigo-500 text-end p-3 hover:opacity-80 transition-all">Already registered? <b>Login</b></a>
    </form>
  </div>
</body>
</html>