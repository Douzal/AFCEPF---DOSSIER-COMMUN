<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="/personne">
		<html>
		<head>
		   <title>personne<xsl:value-of select="@num" /></title>
		</head>
		<body>
		     <i><xsl:value-of select="prenom" /></i> - <b><xsl:value-of select="nom" /></b>
		    <ul>
		     <xsl:for-each select="adresse">
		        <li> 
		           <xsl:value-of select="rue"/> -
		           <xsl:value-of select="cp"/> -
		           <xsl:value-of select="ville" />
		        </li>
		     </xsl:for-each>
		     </ul>
		</body>
		</html>
	</xsl:template>
</xsl:stylesheet>