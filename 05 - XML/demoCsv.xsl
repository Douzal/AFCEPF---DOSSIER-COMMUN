<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" 
	xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 		
	>

<xsl:template match="/">
	<html>
		<head>
			<title>Youpi !</title>
		</head>
		<body>

			<h1>Liste des comptes</h1>
			
			<xsl:variable name="plop" select="banque/@libelle"/>

			<ul>
				<xsl:for-each select="//compte">
					<li>
						<xsl:choose>
							<xsl:when test="../@type='pro'">Professionnel - </xsl:when>
							<xsl:when test="../@type='perso'">Particulier - </xsl:when>
							<xsl:otherwise>inconnu</xsl:otherwise>
						</xsl:choose>
						<xsl:value-of select="../@numero"/> - 
						<xsl:value-of select="@numero"/> - solde : 
						
						
						
						
						<xsl:element name="span">
								<xsl:attribute name="style">
										color:
										<xsl:choose>
											<xsl:when test="solde &gt; 0">
												green
											</xsl:when>
											<xsl:otherwise>
												red
											</xsl:otherwise>
										</xsl:choose>
										;
								</xsl:attribute>
								<xsl:value-of select="solde"/>
						</xsl:element>
						
						
						
					</li>
				</xsl:for-each>		
			</ul>
	
	<xsl:value-of select="$plop"/>
		</body>
	</html>
	

</xsl:template>


</xsl:stylesheet>
