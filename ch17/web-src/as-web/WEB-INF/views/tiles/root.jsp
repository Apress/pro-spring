<%@taglib prefix="tiles" uri="http://jakarta.apache.org/struts/tags-tiles"%>

<html>
<head>
	<link rel=stylesheet type="text/css" href="main.css"/>
		
	<tiles:insert attribute="meta"/>
	<title><tiles:getAsString name="title"/></title>
	<!--<script language="JavaScript" type="text/javascript" src="/sad/static/main.js">
	</script>-->
</head>

<body leftmargin="0" topmargin="0" marginheight="0" marginwidth="0" bgcolor="#0cc000">
<tiles:insert attribute="header"/>
<table cellspacing="0" cellpadding="0" width="700px" align="center" bgcolor="#0000bb">
	<tr>
		<td><tiles:insert attribute="menu"/></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td valign="top" width="800">
			<table cellpadding="0" cellspacing="0" bgcolor="white">
				<!-- Body top -->
				
				<!-- Body header -->
				
				<!-- Body body -->
				<tr height="800px">
					<td valign="top" align=left  bgcolor="yellow" width="150px"><tiles:insert attribute="menu-left"/></td>
					<td width="650" valign="top"><tiles:insert attribute="body"/></td>
					
				</tr>
				<!-- Body footer -->
				
			</table>
		</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td><tiles:insert attribute="footer"/></td>
	</tr>
	<tr>
		<td>&nbsp;</td>
	</tr>
</table>
</body>
</html>
