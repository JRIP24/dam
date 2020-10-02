<?xml version="1.0" encoding="UTF-8" ?>

<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

<xsl:template match="/">

<html>
        <head>
            <title><xsl:value-of select="the_expanse/dades/titol"/></title> 
            <link href="./css/estil_SOLUCIO.css" rel="stylesheet" type="text/css" />
        </head>
        <body>

            <hader>
                <a id="logo_img" href="{the_expanse/dades/pag_web}"><img id="responsive-image" src="./logos/{the_expanse/dades/logo}"></img></a>
            </hader>

            <table>
                    <tr>
                        <th colspan="4">
                            <p>Nº de naus = <xsl:value-of select="count(//nau)"/></p>
                            <p>Nº de noms de naus coneguts = <xsl:value-of select="sum(//@conegudes)"/></p>
                            <p>Nº de acuirasats de Martian_Congressional_Republic_Navy =
                                
                                <xsl:if test="the_expanse/Martian_Congressional_Republic_Navy/nau/tipus = 'Cuirasat'">
                                    <xsl:value-of select="sum(../designacions/@conegudes)"/>
                                </xsl:if>

                            </p>
                            <p>Nº de acuirasats de United_Nations_Navy =
                                    <xsl:if test="the_expanse/United_Nations_Navy/nau/tipus = 'Cuirasat'">
                                    <xsl:value-of select="sum(../designacions/@conegudes)"/>
                                </xsl:if>
                            </p>
                        </th>
                    </tr>

                    <tr>
                        <th class="col1">Nom</th>
                        <th class="col2">Bandol</th>
                        <th class="col3">Característiques</th>
                        <th class="col4">Noms coneguts</th>
                    </tr>

                    
                        <xsl:for-each select="the_expanse/Martian_Congressional_Republic_Navy/nau">
                        <xsl:sort select="tipus" order="descending"/>

                        <xsl:if test="caracteristiques/longitud &gt; 10">
                        <tr>            
                            <td class="col1">
                                    <a href="{web}">
                                        <img src="./imatges/{./imatge}"/>
                                    </a>
                                <p><xsl:value-of select="classe"/></p>
                            </td>
                

                            <td class="col2">
                                <img src="./logos/{logo}"/>
                            </td>

                            <td class="col3">

                                <p>Tipus de nau: <xsl:value-of select="tipus"/></p>

                                <p>Tonelatge: <xsl:value-of select="caracteristiques/tonelatge"/> de <xsl:value-of select="caracteristiques/tonelatge/@unitat"/> </p>
                                <p>Longitud: <xsl:value-of select="caracteristiques/longitud"/> </p>
                                <p>Tripulació: <xsl:value-of select="capacitat_humana/tripulacio"/> </p>
                                
                                <xsl:if test="capacitat_humana/tropes/@enPorta = 'Si'">
                                    <p class="tropes">Tropes: <xsl:value-of select="capacitat_humana/tropes/@quantitat"/>  de <xsl:value-of select="capacitat_humana/tropes"/></p>
                                </xsl:if>
                                
                                <p>Propulsió: <xsl:value-of select="propulsio/numero_de_motors_impulsio"/> reactors de tipus <xsl:value-of select="propulsio/motors_impulsio"/></p>
                                <p>Armament</p>
                                <ul>
                                    <li><xsl:value-of select="armament/canons_de_riel/@quantitat"/> <span>canons de riel </span> <xsl:value-of select="armament/canons_de_riel"/> <span>de tipus </span> <xsl:value-of select="armament/canons_de_riel/@tipus"/></li>
                                    <li><xsl:value-of select="armament/llança_torpedes_davanters/@quantitat"/> <span>llança torpedes davanters de tipus </span> <xsl:value-of select="armament/llança_torpedes_davanters/@tipus"/></li>
                                    <li><xsl:value-of select="armament/llança_torpedes_posteriors/@quantitat"/> <span>llança torpedes posteriors de tipus </span> <xsl:value-of select="armament/llança_torpedes_posteriors/@tipus"/></li>
                                    <li><xsl:value-of select="armament/canons_de_defensa_de_punt/@quantitat"/> <span>canons de defensa de punt </span> <xsl:value-of select="armament/canons_de_defensa_de_punt"/></li>
                                    <li><span>Ampliacions:</span> <xsl:value-of select="armament/ampliacions"/></li>
                                </ul>
        

                                
                            </td>

                            <td class="col4">
                                <ul>
                                    <xsl:for-each select="designacions/nom">
                                        <li><xsl:value-of select="."/></li>
                                    </xsl:for-each>
                                </ul>
                                <p>( Nº noms = <xsl:value-of select="count(designacions/nom)"/>)</p>
                            </td>

                        </tr>

                        <tr>
                            <td colspan="4" class="bottom_link">
                                <a href="{web}"><xsl:value-of select="web"/></a>
                            </td>
                        </tr>
                        </xsl:if>
                        </xsl:for-each>
                

                        <xsl:for-each select="the_expanse/United_Nations_Navy/nau">
                        <xsl:sort select="tipus" order="descending"/>
                        <xsl:if test="caracteristiques/longitud &gt; 10">
                        <tr>

                            <td class="col1">
                                <a href="{web}">
                                    <img src="./imatges/{./imatge}"/>
                                </a>
                                <p><xsl:value-of select="classe"/></p>
                            </td>
                

                            <td class="col2">
                                <img src="./logos/{logo}"/>
                            </td>

                            <td class="col3">
                                <p>Tipus de nau: <xsl:value-of select="tipus"/></p>
                                <p>Tonelatge: <xsl:value-of select="caracteristiques/tonelatge"/> de <xsl:value-of select="caracteristiques/tonelatge/@unitat"/> </p>
                                <p>Longitud: <xsl:value-of select="caracteristiques/longitud"/> </p>
                                <p>Tripulació: <xsl:value-of select="capacitat_humana/tripulacio"/> </p>
                                
                                <xsl:if test="capacitat_humana/tropes/@enPorta = 'Si'">
                                    <p class="tropes">Tropes: <xsl:value-of select="capacitat_humana/tropes/@quantitat"/>  de <xsl:value-of select="capacitat_humana/tropes"/></p>
                                </xsl:if>
                                
                                <p>Propulsió: <xsl:value-of select="propulsio/numero_de_motors_impulsio"/> reactors de tipus <xsl:value-of select="propulsio/motors_impulsio"/></p>
                                <p>Armament</p>
                                <ul>
                                    <li><xsl:value-of select="armament/canons_de_riel/@quantitat"/> <span>canons de riel </span> <xsl:value-of select="armament/canons_de_riel"/> <span>de tipus </span> <xsl:value-of select="armament/canons_de_riel/@tipus"/></li>
                                    <li><xsl:value-of select="armament/llança_torpedes_davanters/@quantitat"/> <span>llança torpedes davanters de tipus </span> <xsl:value-of select="armament/llança_torpedes_davanters/@tipus"/></li>
                                    <li><xsl:value-of select="armament/llança_torpedes_posteriors/@quantitat"/> <span>llança torpedes posteriors de tipus </span> <xsl:value-of select="armament/llança_torpedes_posteriors/@tipus"/></li>
                                    <li><xsl:value-of select="armament/canons_de_defensa_de_punt/@quantitat"/> <span>canons de defensa de punt </span> <xsl:value-of select="armament/canons_de_defensa_de_punt"/></li>
                                    <li><span>Ampliacions:</span> <xsl:value-of select="armament/ampliacions"/></li>
                                </ul>
                                
                            </td>

                            <td class="col4">
                                <ul>
                                    <xsl:for-each select="designacions/nom">
                                        <li><xsl:value-of select="."/></li>
                                    </xsl:for-each>
                                </ul>

                                <p>(Nº noms = <xsl:value-of select="count(designacions/nom)"/>)</p>
                            </td>

                        </tr>

                        <tr>
                            <td colspan="4" class="bottom_link">
                                <a href="{web}"><xsl:value-of select="web"/></a>
                            </td>
                        </tr>
                        </xsl:if>
                        </xsl:for-each>
                    

            </table>
        </body>
</html> 

</xsl:template>
</xsl:stylesheet> 