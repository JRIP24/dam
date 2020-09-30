<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

<html>
        <head>
            <title>practica 5</title> 
            <style>

                *{
                    box-sizing:border-box;
                    outline:none;
                }

                body{
                    background-color:#c9c9c9;
                }

                a{
                    text-align:center;
                    display:block;

                }

                .logo{
                    width:150px;
                }


                table{
                    border: 1px solid blue;
                    margin: auto;
                    margin-top:20px;
                    background-color:white;
                    width:500px;
                }

                tr td{
                    border: 1px solid black;
                }
                td{
                    text-align:center;
                }



            </style>
        </head>
        <body>

            <a target="_blank" >
                <xsl:attribute name="href"> 
                    <xsl:value-of select="UEFA/temporada/organitzador/link"/> 
                </xsl:attribute> 
                <img class="logo">
                    <xsl:attribute name="src"> 
                        <xsl:value-of select="UEFA/temporada/organitzador/logo_uefa"/> 
                    </xsl:attribute> 
                </img>
            </a>

            
            <table>
                    <tr>
                        <th colspan="3">Setzens</th>
                    </tr>
                    <xsl:for-each select="UEFA/temporada/setzens/enfrontament">

                        <tr>
                            <td>
                                <img>
                                    <xsl:attribute name="src"> 
                                        <xsl:value-of select="anada/equip_local/logo"/> 
                                    </xsl:attribute> 
                                </img>
                                <xsl:value-of select="anada/equip_local/gols"/>
                            </td>


                            <td>
                                <xsl:value-of select="anada/equip_visitant/gols"/>
                                <img>
                                    <xsl:attribute name="src"> 
                                        <xsl:value-of select="anada/equip_visitant/logo"/> 
                                    </xsl:attribute> 
                                </img>
                            </td>

                            <td rowspan="2">
                                <img>
                                    <xsl:attribute name="src">

                                        <xsl:if test="anada/equip_visitant/id = guanyador">
                                            <xsl:value-of select="anada/equip_visitant/logo"/>
                                        </xsl:if>

                                        <xsl:if test="anada/equip_local/id = guanyador">
                                            <xsl:value-of select="anada/equip_local/logo"/>
                                        </xsl:if>

                                    </xsl:attribute>
                                </img>
                            </td>

                        </tr>

                        <tr>
                            <td>
                                <img>
                                    <xsl:attribute name="src"> 
                                        <xsl:value-of select="tornada/equip_local/logo"/> 
                                    </xsl:attribute> 
                                </img>
                                <xsl:value-of select="tornada/equip_local/gols"/>
                            </td>


                            <td>
                                <xsl:value-of select="tornada/equip_visitant/gols"/>
                                <img>
                                    <xsl:attribute name="src"> 
                                        <xsl:value-of select="tornada/equip_visitant/logo"/> 
                                    </xsl:attribute> 
                                </img>
                            </td>
                        </tr>

                    </xsl:for-each>
                    

            </table>
        </body>
</html> 

</xsl:template>
</xsl:stylesheet> 