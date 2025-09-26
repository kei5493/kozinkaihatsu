document.addEventListener('DOMContentLoaded', () => {
    const modal = document.getElementById('flowerModal');
    const modalName = document.getElementById('modalName');
    const modalImage = document.getElementById('modalImage');
    const modalLanguage = document.getElementById('modalLanguage');
    const modalBloom = document.getElementById('modalBloom');
    const closeBtn = modal.querySelector('.close');

    document.querySelectorAll('.flower-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            modalName.textContent = btn.dataset.name;
            modalImage.src = btn.dataset.image;
            modalLanguage.textContent = "花言葉：" +  btn.dataset.language;
            modalBloom.textContent = "開花時期：" +  btn.dataset.bloom;
            modal.style.display = 'block';
        });
    });

    closeBtn.addEventListener('click', () => {
        modal.style.display = 'none';
    });
    window.addEventListener('click', (e) => {
        if (e.target === modal) modal.style.display = 'none'; // モーダル外クリックでも閉じる
    });
});
