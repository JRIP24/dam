<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

<html>
        <head>
            <title>M04-UF2-NF2-Pe1</title> 
            <link href="estil_SOLUCIO.css" rel="stylesheet" type="text/css" /> 
        </head>
        <body>

            <hader>

                <h1><xsl:value-of select="root/origen/productor"/></h1>
                <a href="{root/origen/web}"><xsl:value-of select="root/origen/web"/></a>

            </hader>

            <p>Dades per a: <span class="autor"><xsl:value-of select="root/nombre"/> - <xsl:value-of select="root/provincia"/></span></p>

            <table>
                    <tr class="imagen">
                        <td colspan="3">
                            <img src="aemet.jpg" />
                        </td>
                    </tr>
                    <xsl:for-each select="root/prediccion/dia">
                    <xsl:sort select="@fecha" />
                        <tr>
                            <td colspan="3">Data: <span class="fecha"><xsl:value-of select="@fecha"/></span></td>
                        </tr>
                        <tr>
                            <th colspan="3" class="preci_vent">Probabilitat Precipitació</th>
                        </tr>

                        
                        <xsl:for-each select="prob_precipitacion">
                            <tr>
                                <td><xsl:value-of select="@periodo"/></td>
                                <td colspan="2"><xsl:value-of select="."/></td>
                            </tr>
                        </xsl:for-each>

                        <tr>
                            <th colspan="3" class="preci_vent">Dades del Vent</th>
                        </tr>

                        <tr>
                            <th>Periode</th>
                            <th>Direccio</th>
                            <th>Velocitat</th>
                        </tr>

                        <xsl:for-each select="viento">
                            <tr>
                                <td><xsl:value-of select="@periodo"/></td>
                                <td><xsl:value-of select="direccion"/></td>
                                <xsl:if test="velocidad &gt; 8">
                                    <td class="vel_alta"><xsl:value-of select="velocidad"/></td>
                                </xsl:if>

                                <xsl:if test="velocidad &lt;= 8">
                                    <td class="vel_baja"><xsl:value-of select="velocidad"/></td>
                                </xsl:if>
                                
                            </tr>
                        </xsl:for-each>

                        <tr>
                            <th>Quantitat de registres vent</th>
                            <th>Suma velocitats</th>
                            <th>Mitjana velocitat</th>
                        </tr>

                        <tr>
                            <td><xsl:value-of select="count(viento)"/></td>
                            <td><xsl:value-of select="sum(viento/velocidad)"/></td>
                            <td><xsl:value-of select="sum(viento/velocidad) div count(viento/velocidad)"/></td>
                        </tr>

                        <tr>
                            <th colspan="3">Temperatura/UV</th>
                        </tr>

                        <tr>
                            <th>Temp. Máxima</th>
                            <th>Temp. Mínima</th>
                            <th>UV</th>
                        </tr>

                        <tr>
                            <td><xsl:value-of select="temperatura/maxima"/></td>
                            <td><xsl:value-of select="temperatura/minima"/></td>
                            <td><xsl:value-of select="uv_max"/></td>
                        </tr>

                    </xsl:for-each>
                    

            </table>
        </body>
</html> 

</xsl:template>
</xsl:stylesheet> 