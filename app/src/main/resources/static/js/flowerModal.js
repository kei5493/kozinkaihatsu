document.addEventListener('DOMContentLoaded', () => {
    const modal = document.getElementById('flowerModal');
    const modalName = document.getElementById('modalName');
    const modalImage = document.getElementById('modalImage');
    const modalLanguages = document.getElementById('modalLanguages');
    const modalBloom = document.getElementById('modalBloom');
    const closeBtn = modal.querySelector('.close');

    document.querySelectorAll('.flower-btn').forEach(btn => {
        btn.addEventListener('click', () => {
            modalName.textContent = btn.dataset.name;
            modalImage.src = btn.dataset.image;
            modalLanguages.textContent = btn.dataset.languages;
            modalBloom.textContent = btn.dataset.bloom;
            modal.style.display = 'block';
        });
    });

    closeBtn.addEventListener('click', () => {
        modal.style.display = 'none';
    });

    window.addEventListener('click', (e) => {
        if (e.target === modal) {
            modal.style.display = 'none';
        }
    });
});
