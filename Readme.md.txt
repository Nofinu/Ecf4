# Sujet d'ECF: Développement et sécurisation d'une API REST pour la gestion d'un observatoire astronomique virtuel.

## Contexte:
Avec l'augmentation de l'intérêt pour l'astronomie et l'espace, une organisation veut créer une plateforme en ligne où les amateurs d'astronomie peuvent observer des phénomènes spatiaux, enregistrer leurs observations.



- Architecture & Conception:
	1. Choisissez entre une architecture hexagonale ou microservices.
	2. Développement de l'API avec Spring.
        
- Les endpoints doivent :
	1. Lister différents objets célestes.
	2. Permettre aux utilisateurs de créer et de partager leurs observations (dates, descriptions, éventuellement des photos).
	3. Rechercher des observations par objet céleste, date ou utilisateur.

- Sécurisation:
	1. Mettez en œuvre JWT pour l'authentification et l'autorisation.
	2. Seuls les utilisateurs authentifiés peuvent créer des observations.
  3. Les observations peuvent être rendues publiques ou privées par les utilisateurs.

- Tests:
	1. Rédigez des tests unitaires pour les éléments essentiels.
	2. Atteignez une couverture de tests d'au moins 80%.
