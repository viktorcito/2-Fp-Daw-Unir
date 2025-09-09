// main.js

document.addEventListener('DOMContentLoaded', () => {

    const carrito = new Carrito();

    function fetchProducts() {
        fetch('products.json')
            .then(response => response.json())
            .then(data => {
                carrito.currency = data.currency;
                carrito.setProducts(data.products);
                loadCartFromLocalStorage(); 
                renderProducts();
                updateCartSummary();
                updateTotal();
            })
            .catch(error => {
                console.error('Error al obtener los productos:', error);
            });
    }

    function renderProducts() {
        const productList = document.getElementById('product-list');
        productList.innerHTML = '';

        carrito.products.forEach(product => {
            const productDiv = document.createElement('div');
            productDiv.className = 'col-md-6 product';

            const card = document.createElement('div');
            card.className = 'card mb-4 shadow-sm';

            const img = document.createElement('img');
            img.src = product.image;
            img.alt = product.title;
            img.className = 'card-img-top';

            const cardBody = document.createElement('div');
            cardBody.className = 'card-body';

            const title = document.createElement('h5');
            title.className = 'card-title';
            title.textContent = product.title;

            const price = document.createElement('p');
            price.className = 'card-text product-price';
            price.textContent = `Precio: ${carrito.currency}${product.price}`;

            const quantityControls = document.createElement('div');
            quantityControls.className = 'quantity-controls mt-3 d-flex align-items-center';

            const minusButton = document.createElement('button');
            minusButton.className = 'btn btn-sm btn-outline-secondary';
            minusButton.textContent = '-';
            minusButton.addEventListener('click', () => {
                updateQuantity(product.SKU, -1);
            });

            const quantityInput = document.createElement('input');
            quantityInput.type = 'number';
            quantityInput.min = '0';
            quantityInput.value = product.quantity;
            quantityInput.className = 'product-quantity form-control form-control-sm mx-2';
            quantityInput.dataset.sku = product.SKU;
            quantityInput.addEventListener('change', (event) => {
                let units = parseInt(event.target.value);
                if (isNaN(units) || units < 0) {
                    units = 0;
                    event.target.value = 0;
                }
                carrito.actualizarUnidades(product.SKU, units);
                saveCartToLocalStorage();
                updateCartSummary();
                updateTotal();
            });

            const plusButton = document.createElement('button');
            plusButton.className = 'btn btn-sm btn-outline-secondary';
            plusButton.textContent = '+';
            plusButton.addEventListener('click', () => {
                updateQuantity(product.SKU, 1);
            });

            quantityControls.append(minusButton, quantityInput, plusButton);

            cardBody.append(title, price, quantityControls);

            card.append(img, cardBody);
            productDiv.appendChild(card);

            productList.appendChild(productDiv);
        });
    }

    function updateQuantity(sku, change) {
        const product = carrito.products.find(p => p.SKU === sku);
        if (product) {
            product.quantity = Math.max(0, product.quantity + change);

            
            const quantityInput = document.querySelector(`input.product-quantity[data-sku="${sku}"]`);
            if (quantityInput) {
                quantityInput.value = product.quantity;
            }

            saveCartToLocalStorage();
            updateCartSummary();
            updateTotal();
        }
    }

    function updateCartSummary() {
        const cartSummary = document.getElementById('cart-summary');
        const cartInfo = carrito.obtenerCarrito();
        cartSummary.innerHTML = '';

        if (cartInfo.products.length === 0) {
            cartSummary.innerHTML = '<p>El carrito está vacío.</p>';
            return;
        }

        const listGroup = document.createElement('ul');
        listGroup.className = 'list-group';

        cartInfo.products.forEach(product => {
            const item = document.createElement('li');
            item.className = 'list-group-item d-flex justify-content-between align-items-center';

            const itemInfo = document.createElement('span');
            itemInfo.textContent = `${product.title} x ${product.quantity}`;

            const subtotal = document.createElement('span');
            subtotal.className = 'badge badge-primary badge-pill';
            const subtotalAmount = (parseFloat(product.price) * product.quantity).toFixed(2);
            subtotal.textContent = `${carrito.currency}${subtotalAmount}`;

            item.append(itemInfo, subtotal);
            listGroup.appendChild(item);
        });

        cartSummary.appendChild(listGroup);
    }

    function updateTotal() {
        const totalDiv = document.getElementById('total');
        const cartInfo = carrito.obtenerCarrito();
        totalDiv.textContent = `Total: ${carrito.currency}${cartInfo.total}`;
    }

    function saveCartToLocalStorage() {
        const cartState = carrito.products.map(p => ({ SKU: p.SKU, quantity: p.quantity }));
        localStorage.setItem('cart', JSON.stringify(cartState));
    }

    function loadCartFromLocalStorage() {
        const cartState = JSON.parse(localStorage.getItem('cart'));
        if (cartState && Array.isArray(cartState)) {
            cartState.forEach(savedProduct => {
                const product = carrito.products.find(p => p.SKU === savedProduct.SKU);
                if (product) {
                    product.quantity = savedProduct.quantity;
                }
            });
        }
    }

    fetchProducts();
});


