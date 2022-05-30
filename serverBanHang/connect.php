<?php
$host = "localhost";
$username = "truyenbo";
$password = "Truyenbo99";
$database = "project2";
$conn = new mysqli($host, $username, $password, $database);
// Change character set to utf8
$conn->set_charset("utf8");