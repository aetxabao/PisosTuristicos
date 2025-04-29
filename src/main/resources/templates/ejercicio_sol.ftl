<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pisos turísticos</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>
<div class="main-container">

    <h1>${zona}</h1>

    <form class="filtro" action="/" method="get">
        <select name="zona" id="zona">
            <#list zonas as c>
                <option <#if c == zona>selected</#if> value="${c}">${c}</option>
            </#list>
        </select>
        <input type="submit" value="Filtrar">
    </form>
    <br/>
    <#if pisosMunicipios?size == 0>
        <h1 class="alerta">No hay datos para la zona "${zona}"</h1>
    <#else>
        <div class="container">
            <#list pisosMunicipios as m, pisos>
                <h2>${m}</h2>
                <div class="pisos">
                    <#list pisos as p>
                        <div class="piso">
                            <table>
                                <tr>
                                    <th>${p.nombre}</th>
                                </tr>
                                <tr>
                                    <td>
                                        <#if p.categoria == "Primera/3 Llaves">
                                            <img src="imgs/llave.png"/>
                                            <img src="imgs/llave.png"/>
                                            <img src="imgs/llave.png"/>
                                        <#elseif p.categoria == "Segunda/2 Llaves">
                                            <img src="imgs/llave.png"/>
                                            <img src="imgs/llave.png"/>
                                        <#elseif p.categoria == "Tercera/1 Llave">
                                            <img src="imgs/llave.png"/>
                                        </#if>

                                        <#if p.modalidad == "Apartamento Turístico">
                                            AT
                                        <#elseif p.modalidad == "Apartamento Turístico Rural">
                                            ATR
                                        <#elseif p.modalidad == "Vivienda Turística">
                                            VT
                                        <#elseif p.modalidad == "Vivienda Turística Rural">
                                            VTR
                                        </#if>

                                        <img src="imgs/persona.png"/>

                                        ${p.plazas}

                                    </td>
                                </tr>
                                <tr>
                                    <td>${p.direccion}</td>
                                </tr>
                            </table>
                        </div>
                    </#list>
                </div>
            </#list>
        </div>
    </#if>
</div>
</body>
</html>