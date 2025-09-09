

class Carrito {
    constructor(currency) {
        this.products = [];
        this.currency = currency || '€';
    }

    setProducts(products) {
        
        this.products = products.map(product => {
            return {
                ...product,
                quantity: 0
            };
        });
    }

    actualizarUnidades(sku, unidades) {
        
        let product = this.products.find(p => p.SKU === sku);
        if (product) {
            product.quantity = unidades;
        }
    }

    obtenerInformacionProducto(sku) {
        
        let product = this.products.find(p => p.SKU === sku);
        if (product) {
            return {
                sku: product.SKU,
                title: product.title,
                price: product.price,
                quantity: product.quantity,
                image: product.image
            };
        }
        return null;
    }

    obtenerCarrito() {
        
        let productsInCart = this.products.filter(p => p.quantity > 0);
        let total = productsInCart.reduce((sum, product) => {
            return sum + (parseFloat(product.price) * product.quantity);
        }, 0);

        return {
            total: total.toFixed(2),
            currency: this.currency,
            products: productsInCart.map(p => ({
                sku: p.SKU,
                title: p.title,
                price: p.price,
                quantity: p.quantity,
                image: p.image
            }))
        };
    }
}


