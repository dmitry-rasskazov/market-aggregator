import React, { useState } from 'react';
import styles from './FilterComponent.module.css';
import Button from '@mui/material/Button';
import Select from '@mui/material/Select';

const FilterComponent: React.FC = () => {
    const [isOpen, setIsOpen] = useState<{ [key: string]: boolean }>({
        price: false,
        units: false,
        sales: false,
        category: false,
        supplier: false,
        characteristics: false
    });

    const filterFields = [
        { id: 'price', label: 'цена', icon: 'https://dashboard.codeparrot.ai/api/image/Z9k3pJIdzXb5Olay/chevron-d.png' },
        { id: 'units', label: 'количество единиц', icon: 'https://dashboard.codeparrot.ai/api/image/Z9k3pJIdzXb5Olay/chevron-d-2.png' },
        { id: 'sales', label: 'количество продаж', icon: 'https://dashboard.codeparrot.ai/api/image/Z9k3pJIdzXb5Olay/chevron-d-3.png' },
        { id: 'category', label: 'категория', icon: 'https://dashboard.codeparrot.ai/api/image/Z9k3pJIdzXb5Olay/chevron-d-4.png' },
        { id: 'supplier', label: 'поставщик', icon: 'https://dashboard.codeparrot.ai/api/image/Z9k3pJIdzXb5Olay/chevron-d-5.png' },
        { id: 'characteristics', label: 'характеристики', icon: 'https://dashboard.codeparrot.ai/api/image/Z9k3pJIdzXb5Olay/chevron-d-6.png' }
    ];

    const toggleFilter = (id: string) => {
        setIsOpen(prev => ({
            ...prev,
            [id]: !prev[id]
        }));
    };

    const handleApply = () => {
        // Handle apply filter logic here
        console.log('Applying filters');
    };

    return (
        <div className={styles.filterContainer}>
            <h2 className={styles.filterTitle}>Фильтровать по</h2>
            
            {filterFields.map((field) => (
                <div 
                    key={field.id}
                    className={styles.filterField}
                    onClick={() => toggleFilter(field.id)}
                >
                    <span className={styles.filterLabel}>{field.label}</span>
                    <img 
                        src={field.icon} 
                        alt="chevron" 
                        className={`${styles.chevron} ${isOpen[field.id] ? styles.rotated : ''}`}
                    />
                </div>
            ))}

            <Button 
                variant="contained" 
                className={styles.applyButton}
                onClick={handleApply}
            >
                Применить
            </Button>
        </div>
    );
};

export default FilterComponent;

