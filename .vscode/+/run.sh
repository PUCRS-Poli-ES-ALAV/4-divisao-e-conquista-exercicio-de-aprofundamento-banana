#!/bin/bash

echo "🚀 Executando Projeto - Divisão e Conquista"
echo "=========================================="

# Verificar se Maven está instalado
if ! command -v mvn &> /dev/null; then
    echo "❌ Maven não encontrado. Instale o Maven primeiro."
    exit 1
fi

# Verificar se Java está instalado
if ! command -v java &> /dev/null; then
    echo "❌ Java não encontrado. Instale o JDK primeiro."
    exit 1
fi

echo "📦 Compilando projeto..."
mvn clean compile

if [ $? -ne 0 ]; then
    echo "❌ Erro na compilação!"
    exit 1
fi

echo "✅ Compilação bem-sucedida!"
echo ""
echo "🎯 Executando algoritmos..."
echo ""

mvn exec:java

if [ $? -ne 0 ]; then
    echo ""
    echo "❌ Erro na execução!"
    echo "💡 Tente executar manualmente:"
    echo "   mvn exec:java"
    exit 1
fi

echo ""
echo "🎉 Execução concluída com sucesso!"