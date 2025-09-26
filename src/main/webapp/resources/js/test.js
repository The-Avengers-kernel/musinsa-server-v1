$('#productImages').empty();
if (data.productImageList && data.productImageList.length) {
    data.productImageList.forEach(function (img) {
        const imgTag = $('<img>')
            .attr('src', img.imageUrl)
            .attr('alt', img.imageType);
        $('#productImages').append(imgTag);
    });
}