<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div id="catalogue">
    <div class="container">
        <div class="row d-flex wrap">
            <c:if test="${type=='all'}">
            <c:forEach items="${catalogue}" var="c">
                <div class="row">
                    <div class="col-4">
                        <a href="controler?section=CatalogueCtrl&ref=${c.nom}"><div class="card">
                                <img class="card-img-top mx-auto d-block" style="max-height: 150px; width: auto;" src= "${c.image}" title="${c.nom}">
                                <div class="card-body">${c.nom}
                                </div>
                            </div>
                        </a>

                    </div>
                </div>
            </c:forEach>
            </c:if>
            <c:if test="${type=='produit'}">
            <c:forEach items="${catalogue}" var="c">
                <div class="row">
                    <div class="col-4">
                        
                        <a produit="${c.id}" onclick="go(this); return false;" href=""><div class="card">
                            <img class="card-img-top mx-auto d-block" style="max-height: 150px; width: auto;" src= "${c.image}" title="${c.nom}">
                                <div class="card-body">${c.nom}
                                    <%--<div class="card-footer">
                                        <a href="controler?section=Panier&add=${c.id}">ADD</a>
                                        <form action="controler?section=Panier" method="get">
                                        <input type='hidden' name='urlImage' value='${c.id}' />
                                        <INPUT TYPE='SUBMIT' class="btn btn-primary mx-auto d-block" NAME='add' VALUE='Ajouter' />
                                        </form>
                                    </div>--%>
                                </div>
                            </div>
                        </a>
                                
                    </div>
                </div>
            </c:forEach>
            </c:if>
            <c:if test="${type=='menu'}">
            <c:forEach items="${catalogue}" var="c">
                <div class="row">
                    <div class="col-4">
                        
                        <a produit="${c.id}" onclick="go(this); return false;" href=""><div class="card">
                            <img class="card-img-top mx-auto d-block" style="max-height: 150px; width: auto;" src= "${c.image}" title="${c.nom}">
                                <div class="card-body">${c.nom}
                                    <%--<div class="card-footer">
                                        <a href="controler?section=Panier&add=${c.id}">ADD</a>
                                        <form action="controler?section=Panier" method="get">
                                        <input type='hidden' name='urlImage' value='${c.id}' />
                                        <INPUT TYPE='SUBMIT' class="btn btn-primary mx-auto d-block" NAME='add' VALUE='Ajouter' />
                                        </form>
                                    </div>--%>
                                </div>
                            </div>
                        </a>
                                
                    </div>
                </div>
            </c:forEach>
            </c:if>
        </div>
    </div>
</div>
