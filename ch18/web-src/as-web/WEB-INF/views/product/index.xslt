<?xml version="1.0"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	
	<xsl:template match="/">
		<html>
			<head>
				<title>Pro Spring</title>
			</head>
			<body>
				<h1>Available Products</h1>
				<xsl:for-each select="products/product">
					<xsl:value-of select="."/>
					<br />
				</xsl:for-each>
			</body>
		</html>
	</xsl:template>
</xsl:stylesheet>