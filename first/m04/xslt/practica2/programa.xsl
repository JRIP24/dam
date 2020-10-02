<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

<html>
        <head>
                <title>Activitat 2 XSLT</title>
                <style>

                    table{
                        margin:auto;
                    
                    }

                    .titulo{

                        font-weight:bold;
                        background-color:gray;

                    }
                    

                    .nombre{
                        font-weight:bold;
                        background-color:#3e72f0;
                    
                    }


                </style>
        </head>
        <body>
                <table border="1">
                        <tr class="titulo">
                                <th colspan="5">COMANDA</th>
                        </tr>
                        <tr class="titulo">
                                <th>Nom</th>
                                <th colspan="2">Adreça</th>
                                <th>Ciutat</th>
                                <th>C.P.</th>
                        </tr>

                        <xsl:for-each select="Pedido/Destino">
                                <tr>
                                        <td class="nombre"><xsl:value-of select="Nombre"/></td>
                                        <td colspan="2"><xsl:value-of select="Direccion"/></td>
                                        <td><xsl:value-of select="Ciudad"/></td>
                                        <td><xsl:value-of select="CodPostal"/></td>
                                </tr>
                        </xsl:for-each>
                        <tr>
                            <td colspan="5"></td>
                        </tr>
                        <tr>
                            <td colspan="5">Llista amb "Precio &gt; 25" i "Precio &lt;= 100"</td>
                        </tr>

                        <tr>
                            <th colspan="3">Producte</th>
                            <th>Preu</th>
                            <th>Quantitat</th>
                        </tr>
                        <xsl:for-each select="Pedido/Contenido/Producto">
                        <xsl:sort select="Nombre"/>

                            <xsl:if test="Precio > 25"><!--and Precio &lt;= 100-->
                                <tr>
                                    <td colspan="3"><xsl:value-of select="Nombre"/></td>
                                    <td><xsl:value-of select="Precio"/></td>
                                    <xsl:choose>
                                        
                                        <xsl:when test="Cantidad >= 25 and Cantidad &lt; 50">
                                            <td bgcolor="yellow"><xsl:value-of select="Cantidad"/></td>
                                        </xsl:when>

                                        <xsl:when test="Cantidad >= 50 and Cantidad &lt; 75">
                                            <td bgcolor="green"><xsl:value-of select="Cantidad"/></td>
                                        </xsl:when>

                                        <xsl:when test="Cantidad >= 75 and Cantidad &lt;= 10">
                                            <td bgcolor="red"><xsl:value-of select="Cantidad"/></td>
                                        </xsl:when>

                                        <xsl:otherwise>
                                            <td><xsl:value-of select="Cantidad"/></td>
                                        </xsl:otherwise>

                                    </xsl:choose>
                                </tr>
                            </xsl:if>

                        </xsl:for-each>
                        

                </table>
        </body>
</html> 

</xsl:template>
</xsl:stylesheet> 