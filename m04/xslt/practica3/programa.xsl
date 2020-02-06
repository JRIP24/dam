<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

<html>
        <head>
                <title>Activitat 3 XSLT</title>
                <style>

                    *{
                        box-sizing:border-box;
                    }
                    
                    table{
                        margin:auto;
                        border:3px solid black;
                    }

                    .categoria{
                        background-color:#bfbfbf;
                    }

                    span{
                        color:yellow;
                    }

                    .autor{
                        background-color:aqua;
                    }


                </style>
        </head>
        <body>
                <table>
                        <xsl:for-each select="bookstore/book">
                        <xsl:sort select="@category" order="descending"/>
                        <xsl:if test="year = 2003 and price &gt;= 30">
                            <tr>
                                <td class="categoria" colspan="3"><span>Categoria: </span> <xsl:value-of select="@category"/></td>
                            </tr>
                            <tr>
                                <td colspan="2">Títol</td>                                
                                <td><xsl:value-of select="title"/></td>
                            </tr>

                            <tr>
                                <td colspan="2">Any</td>
                                <td><xsl:value-of select="year"/></td>
                            </tr>


                            <tr>
                                <td colspan="2">Preu</td>
                                <td><xsl:value-of select="price"/></td>
                            </tr>


                            <tr>
                                <th class="autor" colspan="3">Autor/s:</th>
                            </tr>

                            
                            <xsl:for-each select="author">
                                <xsl:sort select="."/>
                                <tr>
                                    <td><xsl:value-of select="."/></td>
                                </tr>
                            </xsl:for-each>
                        </xsl:if>
                        </xsl:for-each>
                        

                </table>
        </body>
</html> 

</xsl:template>
</xsl:stylesheet> 