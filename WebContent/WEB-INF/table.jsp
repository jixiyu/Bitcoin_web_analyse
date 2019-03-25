<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="bitcoinViz.web.model.Table"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
    Table tab = (Table)request.getAttribute("tab");
%>

<!DOCTYPE html>
<!--[if IE 9 ]><html class="ie9"><![endif]-->
<html>
<head>
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0" />
<meta name="format-detection" content="telephone=no">
<meta charset="UTF-8">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet">
<script src="http://libs.baidu.com/jquery/1.9.1/jquery.min.js"></script>
<script
	src="https://cdn.bootcss.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title><%=tab.getTitle() %></title>

</head>

<body id="skin-blur-violate">
			<div class="block-area" id="tableHover">
				<h3 class="block-title" style="float:left;">
				<%=tab.getTitle() %>
				</h3>
				<div class="table-responsive overflow" style="clear: both">
					<table class="table table-bordered table-hover tile">
						<thead>
							<tr>
								<%
			    int cols = 0;
								String[] fields=tab.getTHs();
					for (String th : fields) {
					    if (th == null || th.length() == 0)
						break;
					    cols++;
			%>
								<th><%=th%></th>
								
								<%
			    }
			%>
							</tr>
						</thead>
						<tbody>
							<!-- 遍历开始 -->
							<%
		    for (String[] line : tab.getData()) {
		%>
							<tr class="data">
								<%
			    for (int i = 0; i < cols; i++) {
			%>
								<td><%=line[i] %></td>
								<%}
			%>
							</tr> <%
		    }
		%>
							<!-- 遍历结束 -->
						</tbody>
					</table>
				</div>
			</div>
</body>

</html>
