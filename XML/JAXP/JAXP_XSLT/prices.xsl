<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="priceList">
	<html>
		<head>
			Coffee Prices
		</head>
		<body>
			<table border="1">
				<xsl:apply-templates />
			</table>
		</body>
	</html>
</xsl:template>
<xsl:template match="name">
	<tr>
		<td>
		<xsl:apply-templates />
		</td>
	</tr>
</xsl:template>
<xsl:template match="price">
	<tr>
		<td>
		<xsl:apply-templates />
		</td>
	</tr>
</xsl:template>
</xsl:stylesheet>