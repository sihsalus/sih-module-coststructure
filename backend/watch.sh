#!/bin/bash
# ============================================
# 🚚 Script para mover el OMOD al servidor OpenMRS (by d.palomino)
# ============================================

# Nombre del módulo (ajústalo si cambias el nombre)
MODULE_NAME="coststructure-1.0.0-SNAPSHOT"

# Ruta al .omod generado
OMOD_PATH="./omod/target/${MODULE_NAME}.omod"

# Ruta destino del servidor OpenMRS SDK
DEST_PATH="$HOME/openmrs/server2/modules"

# Buscar el archivo .omod más reciente
OMOD_FILE=$(ls -t $OMOD_PATH 2>/dev/null | head -n 1)

if [ -z "$OMOD_FILE" ]; then
  echo "❌ No se encontró ningún archivo .omod en $OMOD_PATH"
  exit 1
fi

echo "📦 Copiando: $OMOD_FILE"
echo "➡️  Destino: $DEST_PATH"

# Copiar al servidor (reemplaza si ya existe)
cp -f "$OMOD_FILE" "$DEST_PATH"

if [ $? -eq 0 ]; then
  echo "✅ Módulo reemplazado correctamente en server2/modules"
else
  echo "❌ Error al copiar el archivo"
fi
