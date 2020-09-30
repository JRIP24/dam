<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

<html>
        <head>
                <title>Activitat 1 XSLT</title>
                <style>

                        table{
                                margin:auto;
                        }

                        .titulo{

                                background-color:#9acd32;
                                text-align:center;
                        }

                        .nombre{
                                background-color:red;
                                font-weight:bold;
                                text-align:center;
                        }

                </style>
        </head>
        <body>
                <table border="1">
                        <tr>
                                <th colspan="3">Classificació</th>
                        </tr>
                        <tr class="titulo">
                                <td>Plataforma del programa</td>
                                <td>Nom</td>
                                <td>Tipus de Llicència</td>
                        </tr>
                        <xsl:for-each select="programes/editors_XML/programa">
                                <xsl:sort select="llicencia"/>
                                <tr>
                                        <td><xsl:value-of select="plataforma"/></td>
                                        <td class="nombre"><xsl:value-of select="nom"/></td>
                                        <td><xsl:value-of select="llicencia"/></td>
                                </tr>
                        </xsl:for-each>
                </table>
        </body>
</html> 

</xsl:template>
</xsl:stylesheet> 