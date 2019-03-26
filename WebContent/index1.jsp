<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search in Blockchain</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<!-- 引入 Bootstrap -->
<link rel="stylesheet" href="css/image.css">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<!-- <script type="text/javascript"
	src="http://www.imooc.com/data/jquery-1.8.2.min.js"></script> -->
<script src="https://code.jquery.com/jquery.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

<script type="text/javascript" src="js/image.js"></script>
</head>

<body class="test">
	<h1 align="center" style="color: white; margin: 0;">
		<span class="glyphicon glyphicon-bitcoin"></span><b>itHunter</b>
	</h1>

	<nav class="navbar navbar-default" style="background-color:#22C3AA;"><!-- 导航条 -->
	<div class="container-fluid">
		<!-- Brand and toggle get grouped for better mobile display -->
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
				aria-expanded="false">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="https://bitcoin.org/en/" target="blank"
				style="margin: 0; padding: 0;"><img src="img/brand.png"
				style="width: 10%"></a>
		</div>

		<!-- Collect the nav links, forms, and other content for toggling -->
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav">
				<li class="active"><a href="https://www.huobi.com/" target="blank">HuoBi<span
						class="sr-only">(current)</span></a></li>
				<li><a href="#">Link</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</ul>
			<form action="tab" class="navbar-form navbar-left">
				<div class="form-group">
					<input type="hidden" name="f" value="RelatedSource"> <input
						type="text" class="form-control" placeholder="Search"
						name="source" size="50">
				</div>
				<button type="submit" class="btn btn-default" formaction="http://127.0.0.1:8080/sBV/relatedSource.html">
					<span class="glyphicon glyphicon-search" ></span>
				</button>
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="#">Link</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li><a href="#">Separated link</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid --> </nav>

	<div id="content" class="row">
		<img src="img/7.jpg">
		<!--主显示区-->
		<div class="col-md-3"></div>
		<div id="scroll_pane" class="col-md-6">
			<div id="player">
				<img src="img/1.jpg"> <img src="img/2.jpg"> <img
					src="img/3.jpg"> <img src="img/4.jpg"> <img
					src="img/5.jpg"> <img src="img/6.jpg">
			</div>
			<!--显示标签-->
			<div id="tags">
				<img src="img/1.jpg"> <img src="img/2.jpg"> <img
					src="img/3.jpg"> <img src="img/4.jpg"> <img
					src="img/5.jpg"> <img src="img/6.jpg">
			</div>
		</div>
	</div>

	<hr style="border: 1px solid #BF3EFF" />


	<div class="row">
		<div class="col-md-1"></div>
		<div class="col-md-4">
			<div class="thumbnail">
				<img src="img/analysis.jpg" alt="Analysis" width="50%">
				<div class="caption">
					<h3>Analysis</h3>
					<p style="font-size: 20px">In this part,&nbsp you can have a
						look at what addresses is used most in every month.</p>
					<p>
						<a href="top3em.html" class="btn btn-primary" role="button"> <span
							class="glyphicon glyphicon-ok"></span><b>search</b></a>
					</p>
				</div>
			</div>
		</div>
		<div class="col-md-1"></div>
		<div class="col-md-6">
			<table>
				<tr>
					<td><hr style="color: white" /></td>
				</tr>
				<tr>
					<td style="font-size: 30px"><a href="http://127.0.0.1:8080/sBV/allTransactions.html"
						style="text-decoration: none;"> <span
							style="font-size: 100px; color: #4876FF"
							class="glyphicon glyphicon-signal"></span> All transactions
					</a></td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
					<td style="font-size: 30px"><a href="tab?f=AllAddresses"
						style="text-decoration: none;"><span style="font-size: 100px"
							class="glyphicon glyphicon-globe"></span> All addresses</a></td>
				</tr>
				<tr>
					<td><hr style="color: white" /></td>
				</tr>
				<tr>
					<td style="font-size: 30px"><a href="multi-bitcoin.html" style="text-decoration: none;"><span
						style="font-size: 100px; color: #4876FF"
						class="glyphicon glyphicon-tasks"></span> Multilevel relation</a></td>
					<td>&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp</td>
					<td style="font-size: 30px"><span style="font-size: 100px"
						class="glyphicon glyphicon-send"></span> <a href="mult/search-result0.html">something</a></td>
				</tr>
			</table>
		</div>
	</div>



	<!-- <table border="1" borderColor="black">
		<tr>
			<td>All Transaction Object</td>
			<td><a href="tab?f=TX">link</a></td>
		</tr>
		<tr>
			<td>All Address</td>
			<td><a href="tab?f=AllAddresses">link</a></td>
		</tr>
		<tr>
			<td>Related Addresses</td>
			<td><form action="tab">
					<input type="hidden" name="f" value="RelatedAddresses"> <input
						name="source"> <input type="submit" value="查询">
				</form></td>
		</tr>
		<tr>
			<td>Graph</td>
			<td><form action="tab">
					<input type="hidden" name="f" value="Graph"> <input
						name="node"> <input type="submit" value="查询">
				</form></td>
		</tr>
		<tr>
			<td>Addresses during this period</td>
			<td>
				<form action="tab">
					<input type="hidden" name="f" value="statistics"> <input
						name="time1"> --- <input name="time2"> <input
						type="submit" value="查询">
				</form>
			</td>
		</tr>
		<tr>
			<td>Top3 of each month</td>
			<td><a href="tab?f=Top3EachMonth">link</a> <a href="top3em.html">page</a></td>
		</tr>
		<tr>
			<td>比特币多级转账关系查询</td>
			<td><a href="http://127.0.0.1:8080/sBV/bitcoinrelation.html">点击查询</a>
			</td>
		</tr>
	</table> -->


</body>
</html>