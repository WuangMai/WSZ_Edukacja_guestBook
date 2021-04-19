<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/header.jsp" %>

<div class="container-fluid">
    <div class="d-sm-flex align-items-center justify-content-between mb-4">
        <h1 class="h3 mb-0 text-gray-800">Księga Gości</h1>
    </div>
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Wpisz się do księgi gości!</h6>
        </div>

        <div class="card-body">
            <div class="mx-5 mb-0" style="width: auto">
                <form method="post" action="">
                    <div class="form-group">
                        <label>Twój nick:</label>
                        <label>${user.nick}test</label><br/>
                        <label for="content"> Dodaj wpis:</label>
                    </div>
                    <div class="form-group mt-0">
                        <textarea id="content" name="content" cols="50" rows="7"></textarea>
                    </div>
                    <button type="submit" class="btn btn-primary" name="action" value="login">Zaloguj</button>
                    <a href="/profil" class="btn btn-secondary">Wróć</a>
                </form>
            </div>
        </div>
    </div>

    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Ostatnie wpisy:</h6>
        </div>

        <div class="mx-4 mb-4 mt-3">
            <div class="card bg-secondary text-white shadow">
                <div class="card-body">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sed est orci. Pellentesque ut
                    aliquam lacus, non dapibus enim. Suspendisse feugiat tristique ante eget tristique. Sed vitae lorem
                    id mauris tempus egestas vel vitae velit. Curabitur mollis nisi quis posuere gravida. Maecenas
                    ornare laoreet elementum. Vestibulum rutrum, erat sit amet pretium egestas, velit velit egestas
                    felis, vitae placerat eros quam quis leo. Sed gravida libero turpis, sit amet vulputate diam
                    tristique quis. Duis et pretium libero, ac ultricies metus. In hac habitasse platea dictumst.
                    Vestibulum at est sed nisi suscipit posuere eget sit amet lectus. Curabitur sed enim cursus,
                    placerat sem vel, sollicitudin erat.

                    Nulla eros augue, feugiat ut interdum in, facilisis at erat. Fusce pretium rutrum arcu. Praesent ut
                    felis et ligula laoreet sodales non non quam. Sed quis nisl neque. Praesent sed pharetra odio. Morbi
                    malesuada ligula at pharetra condimentum. Proin ut enim massa. Nullam malesuada laoreet ex et
                    faucibus.

                    Donec ac finibus mauris, sit amet pharetra enim. Integer quis rutrum leo, id interdum nunc. Fusce
                    vel neque efficitur, commodo nulla eu, finibus tortor. Curabitur a scelerisque augue, non mollis
                    felis. Aenean feugiat ante at lorem dignissim condimentum. Donec eget nulla in sem vehicula feugiat.
                    Cras augue nunc, luctus et ante ut, imperdiet varius nulla. Etiam nibh neque, ultrices et facilisis
                    sed, lobortis non tortor. Etiam sodales neque ut magna tincidunt, ut volutpat mi ultrices. Proin
                    tincidunt arcu id mi finibus euismod. Ut id nisl gravida, hendrerit sem rhoncus, egestas magna.
                    Vivamus in egestas sem, sit amet feugiat neque. Integer eu pellentesque tellus.

                    Aenean pellentesque nulla eget sodales dignissim. Nam porta sollicitudin ante, vitae pharetra nulla.
                    Ut nibh nulla, euismod vel cursus et, ultricies id orci. Duis ut consectetur nisi, sit amet mollis
                    erat. Mauris quis vestibulum nulla, in bibendum ligula. Vivamus imperdiet sit amet est nec rutrum.
                    Ut nibh mi, tincidunt tristique tincidunt ac, iaculis et nulla. Duis facilisis eleifend ipsum, ac
                    lacinia ante tristique ut. Ut dignissim massa ut eros cursus, pharetra euismod lectus luctus.

                    Duis gravida malesuada lectus, vitae pharetra sapien semper ut. Orci varius natoque penatibus et
                    magnis dis parturient montes, nascetur ridiculus mus. Aliquam in nisl massa. In laoreet congue
                    metus. Morbi a cursus erat, non eleifend ante. Vestibulum lobortis neque eu tincidunt sollicitudin.
                    Curabitur pellentesque gravida velit at bibendum. Morbi elementum sem sit amet quam malesuada
                    feugiat. Nunc neque lectus, semper nec mauris sollicitudin, facilisis tincidunt elit. Aliquam
                    rhoncus velit nec nulla faucibus, eu luctus nisl pharetra. Donec rhoncus, dolor sit amet maximus
                    blandit, massa dolor rhoncus odio, sit amet commodo ex risus non neque. Praesent et dui quis enim
                    luctus rutrum. In gravida massa erat, sed elementum tellus suscipit ac.


                    <div class="text-black-50">Autor: ${book.author}test</div>
                    <div class="text-black-50">Data: ${book.date}test2</div>
                </div>
            </div>
        </div>

        <div class="mx-4 mb-4 mt-3">
            <div class="card bg-secondary text-white shadow">
                <div class="card-body">
                    Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur sed est orci. Pellentesque ut
                    aliquam lacus, non dapibus enim. Suspendisse feugiat tristique ante eget tristique. Sed vitae lorem
                    id mauris tempus egestas vel vitae velit. Curabitur mollis nisi quis posuere gravida. Maecenas
                    ornare laoreet elementum. Vestibulum rutrum, erat sit amet pretium egestas, velit velit egestas
                    felis, vitae placerat eros quam quis leo. Sed gravida libero turpis, sit amet vulputate diam
                    tristique quis. Duis et pretium libero, ac ultricies metus. In hac habitasse platea dictumst.
                    Vestibulum at est sed nisi suscipit posuere eget sit amet lectus. Curabitur sed enim cursus,
                    placerat sem vel, sollicitudin erat.

                    Nulla eros augue, feugiat ut interdum in, facilisis at erat. Fusce pretium rutrum arcu. Praesent ut
                    felis et ligula laoreet sodales non non quam. Sed quis nisl neque. Praesent sed pharetra odio. Morbi
                    malesuada ligula at pharetra condimentum. Proin ut enim massa. Nullam malesuada laoreet ex et
                    faucibus.

                    Donec ac finibus mauris, sit amet pharetra enim. Integer quis rutrum leo, id interdum nunc. Fusce
                    vel neque efficitur, commodo nulla eu, finibus tortor. Curabitur a scelerisque augue, non mollis
                    felis. Aenean feugiat ante at lorem dignissim condimentum. Donec eget nulla in sem vehicula feugiat.
                    Cras augue nunc, luctus et ante ut, imperdiet varius nulla. Etiam nibh neque, ultrices et facilisis
                    sed, lobortis non tortor. Etiam sodales neque ut magna tincidunt, ut volutpat mi ultrices. Proin
                    tincidunt arcu id mi finibus euismod. Ut id nisl gravida, hendrerit sem rhoncus, egestas magna.
                    Vivamus in egestas sem, sit amet feugiat neque. Integer eu pellentesque tellus.

                    Aenean pellentesque nulla eget sodales dignissim. Nam porta sollicitudin ante, vitae pharetra nulla.
                    Ut nibh nulla, euismod vel cursus et, ultricies id orci. Duis ut consectetur nisi, sit amet mollis
                    erat. Mauris quis vestibulum nulla, in bibendum ligula. Vivamus imperdiet sit amet est nec rutrum.
                    Ut nibh mi, tincidunt tristique tincidunt ac, iaculis et nulla. Duis facilisis eleifend ipsum, ac
                    lacinia ante tristique ut. Ut dignissim massa ut eros cursus, pharetra euismod lectus luctus.

                    Duis gravida malesuada lectus, vitae pharetra sapien semper ut. Orci varius natoque penatibus et
                    magnis dis parturient montes, nascetur ridiculus mus. Aliquam in nisl massa. In laoreet congue
                    metus. Morbi a cursus erat, non eleifend ante. Vestibulum lobortis neque eu tincidunt sollicitudin.
                    Curabitur pellentesque gravida velit at bibendum. Morbi elementum sem sit amet quam malesuada
                    feugiat. Nunc neque lectus, semper nec mauris sollicitudin, facilisis tincidunt elit. Aliquam
                    rhoncus velit nec nulla faucibus, eu luctus nisl pharetra. Donec rhoncus, dolor sit amet maximus
                    blandit, massa dolor rhoncus odio, sit amet commodo ex risus non neque. Praesent et dui quis enim
                    luctus rutrum. In gravida massa erat, sed elementum tellus suscipit ac.


                    <div class="text-black-50">Autor: ${book.author}test</div>
                    <div class="text-black-50">Data: ${book.date}test2</div>
                </div>
            </div>
        </div>

    </div>
</div>

<%@ include file="/footer.jsp" %>
